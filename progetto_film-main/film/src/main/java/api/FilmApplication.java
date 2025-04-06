package api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class FilmApplication extends ResourceConfig{
	public FilmApplication() {
		packages("api");
	}
}
