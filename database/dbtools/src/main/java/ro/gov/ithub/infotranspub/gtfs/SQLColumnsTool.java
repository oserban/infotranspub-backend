package ro.gov.ithub.infotranspub.gtfs;
import java.lang.String;
import java.lang.StringBuilder;



public class SQLColumnsTool {

	public static String getColumnList(String[] fields) {
		StringBuilder columns = new StringBuilder("(");
		columns.append(String.join("','",fields));
		columns.append("')");
		return columns.toString();
	}
	
	public static String getTableStructure(String[] fields) {
		StringBuilder columns = new StringBuilder("(");
		columns.append(String.join(" text NULL,",fields));
		columns.append(" text NULL)");
		return columns.toString();
	}
}


