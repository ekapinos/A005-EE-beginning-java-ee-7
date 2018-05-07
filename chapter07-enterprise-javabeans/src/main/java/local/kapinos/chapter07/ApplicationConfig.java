package local.kapinos.chapter07;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class ApplicationConfig extends Application {
	
	private final Set<Class<?>> classes;

	public ApplicationConfig() {
		HashSet<Class<?>> c = new HashSet<>();
		c.add(StatelessSessionBeanWithRest.class);
		classes = Collections.unmodifiableSet(c);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
}