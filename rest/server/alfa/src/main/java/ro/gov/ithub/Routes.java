package ro.gov.ithub;

import io.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;

public abstract class Routes
	{
	public static void define(Configuration config, RestExpress server)
    {
		server.uri("/api/listaorase", config.getSampleController())
			.action("readListaOrase", HttpMethod.GET)
			.method(HttpMethod.POST)
			.noSerialization()
			.name(Constants.Routes.SAMPLE_COLLECTION);

		server.uri("/api/cities", config.getCityController())
				.action("getAllCities", HttpMethod.GET)
				.method(HttpMethod.POST)
				.noSerialization()
				.name(Constants.Routes.SAMPLE_COLLECTION);

// or...
//		server.regex("/some.regex", config.getRouteController());
    }
}
