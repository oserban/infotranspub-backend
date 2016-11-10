package ro.gov.ithub.infotranspub.gtfs;
import java.lang.String;
import java.util.HashMap;
import java.util.Set;

public class ColumnPool {

	
    	private HashMap<String,SQLColumns> pool = new HashMap<String,SQLColumns>();

	public ColumnPool(){
		this.createPool();
	}

	private void createPool(){
		this.pool.put(Agency.FILE_NAME,new AgencyColumns(null,null));
		this.pool.put(Stops.FILE_NAME,new StopsColumns(null,null));
		this.pool.put(Calendar.FILE_NAME,new CalendarColumns(null,null));
		this.pool.put(CalendarDates.FILE_NAME,new CalendarDatesColumns(null,null));
	}

	public SQLColumns getColumns(String fileName){
		if (this.pool.containsKey(fileName)){
			return this.pool.get(fileName);
		}
		return null;
	}

	public Set<String> getKeys(){
		return this.pool.keySet();
	}
}

