package local.kapinos.chapter07;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class StartupSingleton {

	Logger logger = Logger.getLogger(getClass().getName());

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this);
	}

}
