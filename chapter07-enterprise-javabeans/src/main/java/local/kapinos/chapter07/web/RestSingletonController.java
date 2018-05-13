package local.kapinos.chapter07.web;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import local.kapinos.chapter07.cdi.SessionScopeCdiBean;

@Path("/singleton")
public class RestSingletonController {

	Logger logger = Logger.getLogger(getClass().getName());

	// can not inject into field. Use constructor 
    // There was no object available for injection at SystemInjecteeImpl(requiredType=SessionScopeCdiBean,parent=RestSingletonController,qualifiers={},position=-1,optional=false,self=false,unqualified=null,482263071)

	//@Inject
	SessionScopeCdiBean sessionScopedCdiBean; 
	@Inject
	public RestSingletonController(SessionScopeCdiBean sessionScopedCdiBean)
	{
		this.sessionScopedCdiBean = sessionScopedCdiBean;
	}

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this);
	}
	
	@GET
	@Produces("text/html")
	@Path("/stateless")
	public String callStateless() {
		logger.info("Call for " + this);
		
		return sessionScopedCdiBean.callBean(true, false);
	}
	
	@GET
	@Produces("text/html")
	@Path("/stateful")
	public String callCdiStateful() {
		logger.info("Call for " + this);
		
		return sessionScopedCdiBean.callBean(false, true);
	}
}

