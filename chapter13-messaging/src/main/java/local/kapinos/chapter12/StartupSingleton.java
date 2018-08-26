package local.kapinos.chapter12;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class StartupSingleton {

	Logger logger = Logger.getLogger(getClass().getName());

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct-" + this);
	}

	@PreDestroy
	public void preDestroy() {
		logger.info("@PreDestroy-" + this);
	}

}