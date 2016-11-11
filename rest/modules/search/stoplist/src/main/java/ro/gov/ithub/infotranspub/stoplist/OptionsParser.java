package ro.gov.ithub.infotranspub.stoplist;
import ro.gov.ithub.infotranspub.stoplist.options.*;
import org.apache.commons.cli.*;

public class OptionsParser {

	Options options = null;
	CommandLine parsedArguments = null;	
	private static final OptionsParser instance = new OptionsParser();

	protected  OptionsParser(){
		options = buildOptions();
	}

	public static OptionsParser getInstance(){
		return instance;
	}

	protected CommandLine parse(String[] args){
			
		CommandLine parsedCommandLine = null;
		try {
			CommandLineParser parser = new DefaultParser();
			parsedCommandLine  = parser.parse( options, args);
		} catch (ParseException e){
			e.printStackTrace();
		}
		return parsedCommandLine;
	}

	public void parseOnce(String[] args){
		if (parsedArguments == null ){
			parsedArguments = parse(args);
			if (parsedArguments == null ) {
				System.exit(1);
			}
			if(parsedArguments.hasOption(OptionHelp.LONG_OPTION) || parsedArguments.hasOption(OptionHelp.SHORT_OPTION)) {
				printHelp();
				System.exit(0);			
			}

			if ( ! (parsedArguments.hasOption(OptionConfigFile.LONG_OPTION) || 
			        parsedArguments.hasOption(OptionConfigFile.SHORT_OPTION) ) ) {
				printHelp();
				System.exit(1);
			}
		}
	}

	public CommandLine getParsedArguments() {
		return parsedArguments;
	}	

	private Options buildOptions(){
		Options acceptedOptions = new Options();
		new OptionHelp().addToOptionList(acceptedOptions);
		new OptionConfigFile().addToOptionList(acceptedOptions);


		Option age = OptionBuilder.withLongOpt("kOptionAge")
		.hasArg()
		.withValueSeparator()
		.withDescription("Age (in days) of cache item before being recomputed")
		.create("a");

		Option server = OptionBuilder.withLongOpt("kOptionNLTServer")
		.hasArg()
		.withValueSeparator()
		.withDescription("The NLT server address")
		.create("s");

		Option numResults = OptionBuilder.withLongOpt("kOptionNumResults")
		.hasArg()
		.withValueSeparator()
		.withDescription("Number of results per item")
		.create("r");

		Option configFile = OptionBuilder.withLongOpt("kOptionConfigFile")
		.hasArg()
		.withValueSeparator()
		.withDescription("Use the specified configuration file")
		.create();

		return	acceptedOptions;
	}

	public void printHelp(){
		String header = "Do something useful with an input file\n\n";
		String footer = "\nPlease report issues at http://ithub.gov.ro/issues";

		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("stoplist", header, options, footer, true);
	}
}


