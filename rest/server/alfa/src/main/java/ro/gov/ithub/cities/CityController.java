package ro.gov.ithub.cities;

import org.restexpress.Request;
import org.restexpress.Response;
import ro.gov.ithub.Oras;
import ro.gov.ithub.base.BaseController;
import ro.gov.ithub.delegate.SearchDelegate;

import java.util.*;

public class CityController extends BaseController<City> {

	public CityController()
	{
		super();
	}

	public List<City> getAllCities(Request request, Response response)
	{
		//TODO: Your 'GET collection' logic here...
		printOutRequest(request);

		List<City>  list = new ArrayList<>();
		list.add(new City(1, "Bucuresti"));
		list.add(new City(2, "Cluj-Napoca"));
		list.add(new City(3, "Oradea"));
		list.add(new City(4, "Iasi"));
		list.add(new City(5, "Timisoara"));

		return list;
	}

	private void printOutRequest(Request request) {
		Map<String, String> hmap = request.getQueryStringMap();

		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());
		}
	}
}
