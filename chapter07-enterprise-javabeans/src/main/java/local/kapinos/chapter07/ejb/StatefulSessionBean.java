package local.kapinos.chapter07.ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

@Stateful
public class StatefulSessionBean {

	Logger logger = Logger.getLogger(getClass().getName());

	@Resource // @Inject does not work
	SessionContext sessionContext;
	
	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this);
	}

	public String callBean() {
		logger.info("Call for " + this);
		logger.info(" caller="+sessionContext.getCallerPrincipal());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "See log " + this;
	}
}
