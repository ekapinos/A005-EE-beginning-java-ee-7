package local.kapinos.chapter07.ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Chain03 {

	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	Chain02 nextChainElement;
	
	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this);
	}
	
	public void call()
	{
		logger.info("Call for " + this);
		nextChainElement.call();
	}
}
