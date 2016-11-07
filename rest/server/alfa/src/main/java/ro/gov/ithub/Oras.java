package ro.gov.ithub;
import com.google.gson.Gson;
public class Oras {
	private String name;
	private static Gson gson = new Gson();
	public Oras(){
		name = null;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
    	public String toString() {
 
		String json = gson.toJson(this);
		return json;	

    }

}


