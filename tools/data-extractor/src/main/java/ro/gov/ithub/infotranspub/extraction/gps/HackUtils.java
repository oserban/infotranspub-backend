package ro.gov.ithub.infotranspub.extraction.gps;

public class HackUtils {
    public static String fixAddresses(String data) {
        return data.toLowerCase().replaceAll("sos. ", "soseaua ").replaceAll("cal. ", "calea ");
    }
}
