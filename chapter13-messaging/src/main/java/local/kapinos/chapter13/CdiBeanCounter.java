package local.kapinos.chapter13;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("counter") // For access from JSF via EL
@ApplicationScoped
@SuppressWarnings("serial")
public class CdiBeanCounter implements Serializable {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	private int sentMessagesCountQueue = 0;
	private int receivedMessagesCountQueue = 0;
	private int sentMessagesCountTopic = 0;
	private int receivedMessagesCountTopic = 0;

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct-" + this);
	}

	@PreDestroy
	public void preDestroy() {
		logger.info("@PreDestroy-" + this);
	}
	
	public void incrementSentMessagesCountQueue(){
		sentMessagesCountQueue++;
	}	
	public int getSentMessagesCountQueue() {
		return sentMessagesCountQueue;
	}
	
	public void incrementReceivedMessagesCountQueue(){
		receivedMessagesCountQueue++;
	}
	public int getReceivedMessagesCountQueue() {
		return receivedMessagesCountQueue;
	}

	public void incrementSentMessagesCountTopic(){
		sentMessagesCountTopic++;
	}	
	public int getSentMessagesCountTopic() {
		return sentMessagesCountTopic;
	}
	
	public void incrementReceivedMessagesCountTopic(){
		receivedMessagesCountTopic++;
	}
	public int getReceivedMessagesCountTopic() {
		return receivedMessagesCountTopic;
	}

}