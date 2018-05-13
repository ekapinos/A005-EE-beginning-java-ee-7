package local.kapinos.chapter07.web;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import local.kapinos.chapter07.cdi.SessionScopeCdiBean;

@ApplicationPath("/rest")
public class RestApplicationConfig extends Application {

	//@Inject
	SessionScopeCdiBean sessionScopedCdiBean;

	@Inject
	RestSingletonController restSingletonController;

	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> c = new HashSet<>();
		c.add(RestController.class);
		//c.add(RestSingletonController.class);
		return c;
	}
	
	@Override
	public Set<Object> getSingletons() {
		HashSet<Object> c = new HashSet<>();
//		c.add(new RestSingletonController(sessionScopedCdiBean));
		c.add(restSingletonController);
		return c;		
	}
}