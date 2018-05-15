package local.kapinos.chapter07.cdi;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

@SessionScoped
@SuppressWarnings("serial")
public class CdiChain01  implements Serializable {

	Logger logger = Logger.getLogger(getClass().getName());

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this); 
	}

	public void call() {
		logger.info("Call for " + this);
		

	}
}
