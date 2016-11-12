package ro.gov.ithub.infotranspub.dbtools.processors;
import ro.gov.ithub.infotranspub.gtfs.MetaPool;
import ro.gov.ithub.infotranspub.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.IOException;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class SQLTempTableProcessor implements GenericProcessor{

	private int cnt = 500;
	private int lineCount = 0;
    	private String []  header = null;
	private String entryName = null;
	private String tableRadix = null;
	private Boolean skipIt = false;
	private java.sql.Connection sqlConnection = null;
	private java.sql.Statement sqlStatement= null;	
	private MetaPool metaPool = new MetaPool();
	private StringBuilder inserter = null;
	private StringBuilder multipleValues = null;
	private StringBuilder sqlQuery = null;
	
	public SQLTempTableProcessor(String entryName) {
		this.entryName = entryName;
		try {
			DataSource dataSource = DataSource.getInstance();
			this.sqlConnection = dataSource.getConnection();
			this.sqlStatement = sqlConnection.createStatement();
			String[] name = entryName.split("\\.");
			this.tableRadix = name[0];
		} catch ( SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public Boolean process(){
		return false;
	}
	@Override
	public Boolean process(String line){
		return false;
	}

	public void processHeader(String line){
		
		String  tableStructure = this.metaPool.getColumns(entryName).getTableStructure();
		StringBuilder createTable = new StringBuilder("CREATE TABLE TMP_" + this.tableRadix + tableStructure);
		 
		try {
			System.out.println(createTable.toString());
			this.sqlStatement.executeUpdate(createTable.toString());
		} catch ( SQLException e){
			e.printStackTrace();
		}
		System.out.println(this.entryName);

		
	    	inserter = new StringBuilder("INSERT INTO TMP_"+this.tableRadix + "(" );
            	header = line.split(",");
		//inserter.append(String.join(",", header));
		inserter.append(StringUtils.join(header,","));
		inserter.append(") VALUES ");
	}

	public void processBody(String line){
		String[] cells = evenQuoteSplit(line.replaceAll("'","''")); //.split(",");
	//	if (cells.length > 0)
	//		return;	
		if (cells.length < header.length){
			List<String> newCells = new ArrayList<String>();
			for (String cell:cells){
				newCells.add(cell.trim());
			}
			while (newCells.size() < header.length){
				newCells.add("");
			}
			cells = (String[])newCells.toArray(cells);
		}
		if ((this.lineCount % this.cnt) == 0){
	        	sqlQuery = new StringBuilder(inserter.toString());
		}
                if ((this.lineCount % this.cnt) > 0 ){
			sqlQuery.append(",");
		}
		
		StringBuilder val = new StringBuilder("('");
		//val.append(String.join("','",cells));
		val.append(StringUtils.join(cells,"','"));
		val.append("')");
		sqlQuery.append(val.toString());
		sqlQuery.append("\n");

                if ((this.lineCount > 0) && (((this.lineCount+1)%this.cnt) == 0)){ 
		
			try {
				//System.out.println(sqlQuery.toString());
				this.sqlStatement.executeUpdate(sqlQuery.toString());
			    } catch (SQLException e ) {
				e.printStackTrace();
			    }
               } 
		this.lineCount++;	
	}

	public void processTail(){
//		if (this.lineCount >=0)
//			return;
                if ((this.lineCount > 0) && (((this.lineCount+1) % this.cnt) != 0)){ 
			try {
				this.sqlStatement.executeUpdate(sqlQuery.toString());
			    } catch (SQLException e ) {
				e.printStackTrace();
			    }
               } 
		
			try {
				this.sqlStatement.close();
				this.sqlConnection.close();
			//	DataSource.getInstance().close();
			    } catch (SQLException e ) {
				e.printStackTrace();
			    }
	}

	public String[]  evenQuoteSplit(String line){
/*
		String inputString = line;
		    char quote = '"';
		    List<String> csvList = new ArrayList<String>();
		    boolean inQuote = false;
		    int lastStart = 0;
		    for (int i = 0; i < inputString.length(); i++) {
			if ((i + 1) == inputString.length()) {
			    //if this is the last character
			    csvList.add(inputString.substring(lastStart, i + 1));
			}
			if (inputString.charAt(i) == quote) {
			    //if the character is quote
			    if (inQuote) {
				inQuote = false;
				continue; //escape
			    }
			    inQuote = true;
			    continue;
			}
			if (inputString.charAt(i) == ',') {
			    if (inQuote) continue;
			    csvList.add(inputString.substring(lastStart, i));
			    lastStart = i + 1;
			}
		    }
		return csvList.toArray(new String[0]);

*/


		List<String> result = new ArrayList<String>();
		int start = 0;
		boolean inQuotes = false;
		for (int current = 0; current < line.length(); current++) {
		    if (line.charAt(current) == '\"') inQuotes = !inQuotes; // toggle state
		    boolean atLastChar = (current == line.length() - 1);
		    if(atLastChar) result.add(line.substring(start));
		    else if (line.charAt(current) == ',' && !inQuotes) {
			result.add(line.substring(start, current));
			start = current + 1;
		    }
		}
		return result.toArray(new String[0]);

	}

}
