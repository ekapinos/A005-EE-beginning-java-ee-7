package local.kapinos.chapter08.ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton
@Startup
public class TimerSingleton {

	Logger logger = Logger.getLogger(getClass().getName());

	@Resource // Inject does not work
	TimerService timerService;
	
	@PostConstruct
	private void populateDB() {		
		TimerConfig timerConfig = new TimerConfig("Data", false);
		Timer timer = timerService.createIntervalTimer(1000L, 15000, timerConfig);
		logger.info("Create timer="+timer);
	}
	
	@Timeout
	public void timeout(Timer timer) {
		logger.info("@Timeout timer="+timer);
	}
	
	@Schedule(hour = "*", minute = "*", second = "0" )
	public void schedule() {
		logger.info("@Schedule");
	}

}