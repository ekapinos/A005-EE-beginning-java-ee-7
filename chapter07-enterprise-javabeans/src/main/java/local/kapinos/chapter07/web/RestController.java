package local.kapinos.chapter07.web;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import local.kapinos.chapter07.ejb.StatefulSessionBean;
import local.kapinos.chapter07.ejb.StatelessSessionBean;

@Path("/")
public class RestController {

	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	StatelessSessionBean statelessSessionBean;
	
	@Inject
	StatefulSessionBean statefulSessionBean;

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this); // new instance on each request
	}
	
	@GET
	@Produces("text/html")
	@Path("/stateless")
	public String callStateless() {
		logger.info("Call for " + this);
		
		return statelessSessionBean.callBean();
	}
	
	@GET
	@Produces("text/html")
	@Path("/stateful")
	public String callStateful() {
		logger.info("Call for " + this);
		
		return statefulSessionBean.callBean();
	}	
}

