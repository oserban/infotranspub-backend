package ro.gov.ithub.infotranspub.dbtools.processors;
import ro.gov.ithub.infotranspub.gtfs.MetaPool;
import ro.gov.ithub.infotranspub.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.IOException;
import java.lang.String;
import java.lang.StringBuilder;


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
		
		System.out.println("process header");
		String  tableStructure = this.metaPool.getColumns(entryName).getTableStructure();
		StringBuilder createTable = new StringBuilder("CREATE TABLE TMP_" + this.tableRadix + tableStructure);
		 
		System.out.println(createTable.toString());
		try {
			this.sqlStatement.executeUpdate(createTable.toString());
		} catch ( SQLException e){
			e.printStackTrace();
		}
		System.out.println(this.entryName);
		System.out.println(line);

		
	    	inserter = new StringBuilder("INSERT INTO TMP_"+this.tableRadix + "(" );
            	header = line.split(",");
		inserter.append(String.join(",", header));
		inserter.append(") VALUES ");
	}

	public void processBody(String line){
		System.out.println("process body");
		String[] cells = line.replaceAll("'","''").split(",");
		if ((this.lineCount % this.cnt) == 0){
	        	sqlQuery = new StringBuilder(inserter.toString());
		}
                if ((this.lineCount % this.cnt) > 0 ){
			sqlQuery.append(",");
		}
		
		StringBuilder val = new StringBuilder("('");
		val.append(String.join("','",cells));
		val.append("')");
		System.out.println(val.toString());
		sqlQuery.append("\n");
		sqlQuery.append(val.toString());	

                if ((this.lineCount > 0) && (((this.lineCount+1)%this.cnt) == 0)){ 
		
			try {
				this.sqlStatement.executeUpdate(sqlQuery.toString());
			    } catch (SQLException e ) {
				e.printStackTrace();
			    }
               } 
		this.lineCount++;	
	}

	public void processTail(){
		System.out.println("process tail");
                if ((this.lineCount > 0) && (((this.lineCount+1) % this.cnt) != 0)){ 
			try {
				this.sqlStatement.executeUpdate(sqlQuery.toString());
			    } catch (SQLException e ) {
				e.printStackTrace();
			    }
               } 
	}

}
