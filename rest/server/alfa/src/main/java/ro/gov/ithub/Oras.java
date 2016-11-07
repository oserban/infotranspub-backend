package ro.gov.ithub;
import com.google.gson.Gson;
public class Oras {
	private String name;
	private int id;
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
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
    	public String toString() {
 
		String json = gson.toJson(this);
		return json;	

    }

}


