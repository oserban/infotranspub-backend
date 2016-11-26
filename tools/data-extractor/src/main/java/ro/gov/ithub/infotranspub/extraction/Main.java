package ro.gov.ithub.infotranspub.extraction;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ro.gov.ithub.infotranspub.extraction.data.Line;
import ro.gov.ithub.infotranspub.extraction.data.LineType;
import ro.gov.ithub.infotranspub.extraction.extractor.CrawlerFactory;
import ro.gov.ithub.infotranspub.extraction.extractor.GenericCrawler;
import ro.gov.ithub.infotranspub.extraction.gps.GpsDataFixer;
import ro.gov.ithub.infotranspub.extraction.output.JsonFileCache;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String CACHE_SUB_PATH = "extracted";

    public static void main(String[] args) throws Exception {
        RunParameters params = new RunParameters();
        JCommander cmdParser = new JCommander(params);
        cmdParser.setProgramName("data-extractor");
        try {
            cmdParser.parse(args);
        } catch (ParameterException e) {
            failToStart(cmdParser, e.getMessage(), 1);
        }

        if (params.help) {
            printUsage(cmdParser);
        }

        printParameters(params);

        File cacheFolder = createCacheFolder(params.cacheFolder, params.extractor);
        GenericCrawler crawler = CrawlerFactory.createCrawler(params.extractor);
        GpsDataFixer dataFixer = null;
        if (params.fixGpsCoordinates) {
            dataFixer = new GpsDataFixer();
        }

        for (LineType type : LineType.values()) {
            List<String> lineIds = crawler.parseLinesIds(type);
            logger.info(type + " = " + lineIds);

            JsonFileCache fileCache = new JsonFileCache(cacheFolder.getAbsolutePath() + File.separator + "%s.json");
            for (String lineId : lineIds) {
                logger.info("Parsing line = " + lineId);

                Line lineInformation = null;
                if (fileCache.shouldUpdate(lineId, params.updateExisting)) {
                    lineInformation = crawler.parseLine(type, lineId);
                    if (lineInformation != null) {
                        fileCache.write(lineInformation);
                        logger.info("Line parsed ...");
                    } else {
                        logger.error("Failed to parse line information on " + lineId);
                    }
                } else if (params.useCache) {
                    logger.info("Line exists, but using cache to load data ...");
                    lineInformation = fileCache.read(lineId);
                } else {
                    logger.info("Line exists ... lineInformation is null ...");
                }

                if (dataFixer != null && lineInformation != null) {
                    dataFixer.fixLine(lineInformation);
                    fileCache.write(lineInformation);
                }
            }
        }
    }

    private static File createCacheFolder(String cachePath, String extractorName) throws IOException {
        File cachePathFile = new File(cachePath);
        if (cachePathFile.canWrite()) {
            File cacheFolder = new File(new File(cachePathFile, extractorName), CACHE_SUB_PATH);
            if (cacheFolder.exists()) {
                if (cacheFolder.canWrite()) {
                    return cacheFolder;
                } else {
                    throw new IOException("Unable to write in " + cacheFolder.getAbsolutePath());
                }
            } else {
                if (cacheFolder.mkdirs()) {
                    return cacheFolder;
                } else {
                    throw new IOException("Unable to create cache folder at " + cacheFolder.getAbsolutePath());
                }
            }
        } else {
            throw new IOException("Unable to write in " + cachePathFile.getAbsolutePath());
        }
    }

    private static void failToStart(JCommander cmdParser, String message, int exitCode) {
        logger.error("Error running data-extractor: " + message);
        StringBuilder sb = new StringBuilder();
        cmdParser.usage(sb);
        logger.error(sb.toString());
        System.exit(exitCode);
    }

    private static void printUsage(JCommander cmdParser) {
        StringBuilder sb = new StringBuilder();
        cmdParser.usage(sb);
        logger.info(sb.toString());
        System.exit(0);
    }

    private static void printParameters(RunParameters runParameters) {
        StringBuilder sb = new StringBuilder();
        for (Field field : runParameters.getClass().getDeclaredFields()) {
            try {
                sb.append("\t").append(field.getName()).append(" = ").append(field.get(runParameters)).append("\n");
            } catch (IllegalAccessException e) {
                //-- ignore
            }
        }
        logger.info("Service parameters: \n" + sb.toString());
    }


    public static class RunParameters {
        @Parameter(names = {"-h", "--help"}, description = "Print this help", help = true, echoInput = true)
        public boolean help = false;

        @Parameter(names = {"--extractor"}, description = "The extractor to run: ratb")
        public String extractor = "ratb";

        @Parameter(names = {"--update"}, description = "Update existing data")
        public boolean updateExisting = false;

        @Parameter(names = {"--useCache"}, description = "Use cached version instead of the live one, if it exists")
        public boolean useCache = true;

        @Parameter(names = {"--cacheFolder"}, description = "Cache folder")
        public String cacheFolder = "data";

        @Parameter(names = {"--fixGpsCoordinates"}, description = "Fix the missing GPS coordinates")
        public boolean fixGpsCoordinates = true;
    }
}
