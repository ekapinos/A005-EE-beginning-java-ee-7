package local.kapinos.chapter07.ejb;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.kapinos.chapter07.model.C07_Test;

@Stateless
public class StatelessSessionBean {

	Logger logger = Logger.getLogger(getClass().getName());

	@PersistenceContext
	EntityManager em;
	
	@Resource // @Inject does not work
	SessionContext sessionContext;
	
	@PostConstruct
	public void postConstruct() {
		logger.warning("@PostConstruct for " + this);
	}

	public String callBean() {
		logger.info("callBean() for " + this);
		//logger.info(" isJoinedToTransaction="+em.isJoinedToTransaction()); //true
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
		
		String caller = sessionContext.getCallerPrincipal().getName();
		logger.info(" caller="+sessionContext.getCallerPrincipal());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "See log " + this + "<br>" + 
		        "<br> oldValue=" + value + 
				"<br> newValue=" + newValue +
				"<br> caller=" + caller;
	}
}
