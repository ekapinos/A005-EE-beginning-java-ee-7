package local.kapinos.chapter07.cdi;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CdiChain02 {

	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	CdiChain01 chain;

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this); 
	}

	public void call() {
		logger.info("Call for " + this);
		
		chain.call();
	}
}
