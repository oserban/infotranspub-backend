package ro.gov.ithub;
import ro.gov.ithub.delegate.SearchDelegate;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import org.restexpress.Request;
import org.restexpress.Response;

public class SampleController
{
	private SearchDelegate searchDelegate = new SearchDelegate();
	public SampleController()
	{
		super();
	}

	public Object create(Request request, Response response)
	{
		//TODO: Your 'POST' logic here...
		return null;
	}

	public Object read(Request request, Response response)
	{
		//TODO: Your 'GET' logic here...
		return null;
	}

	public List<Object> readAll(Request request, Response response)
	{
		//TODO: Your 'GET collection' logic here...
		return Collections.emptyList();
	}

	public List<Object> readListaOrase(Request request, Response response)
	{
		return searchDelegate.readListaOrase(request,response);
	}

	public void update(Request request, Response response)
	{
		//TODO: Your 'PUT' logic here...
		response.setResponseNoContent();
	}

	public void delete(Request request, Response response)
	{
		//TODO: Your 'DELETE' logic here...
		response.setResponseNoContent();
	}
}
