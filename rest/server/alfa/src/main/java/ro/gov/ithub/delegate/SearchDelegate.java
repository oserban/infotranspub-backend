package ro.gov.ithub.delegate;

import org.restexpress.Request;
import org.restexpress.Response;
import ro.gov.ithub.city.City;

import java.util.*;

public class SearchDelegate
{
	public SearchDelegate()
	{
		super();
	}

	public List<Object> readListaOrase(Request request, Response response)
	{
		//TODO: Your 'GET collection' logic here...
		Map<String, String> hmap = request.getQueryStringMap();

	Set set = hmap.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
		 Map.Entry mentry = (Map.Entry)iterator.next();
		 System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
		 System.out.println(mentry.getValue());
	      }

		List<Object>  list = new ArrayList<>();
		list.add(new City(1, "Bucuresti"));
		list.add(new City(2, "Iasi"));
		return list;
	}
}
