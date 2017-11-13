package local.kapinos.chapter03;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class StartupSingleton {

	Logger logger = Logger.getLogger(getClass().getName());

	
	@PostConstruct
	public void postConstruct(){
		logger.log(Level.WARNING, "@PostConstruct " + this.getClass().getSimpleName());
	}
	
	@PreDestroy
	public void postDestroy(){
		logger.log(Level.WARNING, "@PreDestroy " + this.getClass().getSimpleName());
	}	
}
