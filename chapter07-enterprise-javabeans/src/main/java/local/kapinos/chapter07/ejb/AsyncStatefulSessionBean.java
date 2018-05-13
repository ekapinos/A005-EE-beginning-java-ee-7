package local.kapinos.chapter07.ejb;

import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateful;

@Stateful
public class AsyncStatefulSessionBean {

	Logger logger = Logger.getLogger(getClass().getName());

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this);
	}

	@Asynchronous
	public Future<String> callBean() {
		logger.info("Call for " + this);
		
		try 
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		return new AsyncResult<>("Delayed text");
	}
}
