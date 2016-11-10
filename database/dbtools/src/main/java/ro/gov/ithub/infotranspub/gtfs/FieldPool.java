package ro.gov.ithub.infotranspub.gtfs;
import java.lang.String;
import java.util.HashMap;
import java.util.Set;

public class FieldPool {

	
    	private HashMap<String,GTFSFields> pool = new HashMap<String,GTFSFields>();

	public FieldPool(){
		this.createPool();
	}

	private void createPool(){
		this.pool.put(Agency.FILE_NAME,new AgencyFields());
		this.pool.put(Stops.FILE_NAME,new StopsFields());
	}

	public GTFSFields getFields(String fileName){
		if (this.pool.containsKey(fileName)){

			return this.pool.get(fileName);
		}
		return null;
	}

	public Set<String> getKeys(){
                return this.pool.keySet();
        }
}

