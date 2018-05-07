package local.kapinos.chapter07;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import local.kapinos.chapter07.model.C07_Test;

@Stateless
@Path("/")
public class StatelessSessionBeanWithRest {

	Logger logger = Logger.getLogger(getClass().getName());

	@PersistenceContext
	EntityManager em;

	@PostConstruct
	public void postConstruct() {
		logger.warning("@PostConstruct for " + this);
	}

	@GET
	@Produces("text/html")
	public String callRest() {
		logger.info("root / for " + this + ", isJoinedToTransaction="+em.isJoinedToTransaction());
		C07_Test test = em.find(C07_Test.class, 1);
		String value= null;
		String newValue = new Date().toString();
		if (test != null)
		{
			value = test.getValue();
			test.setValue(newValue);
		}
		else
		{
			test = new C07_Test(newValue);
			em.persist(test);
		}
		
		return "root / was called DB value=" + value + ", newValue=" + newValue;
	}
}
