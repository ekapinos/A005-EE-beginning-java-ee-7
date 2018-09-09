package local.kapinos.chapter13;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("messageCounterCdiBean") // For access from JSF via EL
@SuppressWarnings("serial")
public class CounterCdiBean implements Serializable {

	private Logger logger = Logger.getLogger(getClass().getName());
	private int sentMessagesCount = 0;
	private int receivedMessagesCount = 0;

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct-" + this);
	}

	@PreDestroy
	public void preDestroy() {
		logger.info("@PreDestroy-" + this);
	}
	
	public void incrementSentMessagesCount(){
		sentMessagesCount++;
	}
	
	public int getSentMessagesCount() {
		return sentMessagesCount;
	}
	
	public void incrementReceivedMessagesCount()
	{
		receivedMessagesCount++;
	}
	public int getReceivedMessagesCount() {
		return receivedMessagesCount;
	}

}