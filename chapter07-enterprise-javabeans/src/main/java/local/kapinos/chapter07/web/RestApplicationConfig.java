package local.kapinos.chapter07.web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> c = new HashSet<>();
		c.add(RestController.class);
		return c;
	}
}