package ro.gov.ithub.infotranspub;
import ro.gov.ithub.infotranspub.stoplist.OptionsParser;
import ro.gov.ithub.infotranspub.stoplist.ConfigProps;
import ro.gov.ithub.infotranspub.stoplist.options.OptionConfigFile;
import ro.gov.ithub.infotranspub.sql.DataSource;
import ro.gov.ithub.infotranspub.sql.Connection;
import ro.gov.ithub.infotranspub.sql.Statement;
import ro.gov.ithub.infotranspub.sql.ResultSet;
import org.apache.commons.cli.*;
import org.apache.commons.cli.DefaultParser;
import java.sql.SQLException;

public class App {
    public static void main( String[] args ) throws ParseException {

	OptionsParser.getInstance().parseOnce(args);
	
	String configFile = OptionsParser.getInstance().getParsedArguments().getOptionValue(OptionConfigFile.LONG_OPTION);
	ConfigProps.getInstance().load(configFile);	
		
	Connection connection = new Connection();
	Statement statement = connection.createStatement();	
	ResultSet resultSet = statement.executeQuery("SELECT * from t_stops");

	try {
        while (resultSet.getRealResultSet().next()) {
            String name = resultSet.getRealResultSet().getString("name");
		System.out.println(name);
        }
	statement.getRealStatement().close();
    } catch (SQLException e ) {
        e.printStackTrace();
	}	

    }
}


