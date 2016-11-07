package ro.gov.ithub.delegate;

import ro.gov.ithub.Oras;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import org.restexpress.Request;
import org.restexpress.Response;

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
		List<Object>  list = new ArrayList<Object>();
		Oras oras = new Oras();
		oras.setName("Bucuresti");
		oras.setId(1);
		list.add(oras);
		oras = new Oras();
		oras.setName("Iasi");
		oras.setId(2);
		list.add(oras);

		
		return list;
	}
}
