package local.kapinos.chapter07.ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class Chain01 {

	Logger logger = Logger.getLogger(getClass().getName());

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this);
	}
	
	public void call()
	{
		logger.info("Call for " + this);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
