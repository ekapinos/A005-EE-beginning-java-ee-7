package local.kapinos.chapter07.cdi;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class CdiChain03 {

	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	CdiChain02 chain;
	
	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this); 
	}

	public void call() {
		logger.info("Call for " + this);
		chain.call();
	}
}
