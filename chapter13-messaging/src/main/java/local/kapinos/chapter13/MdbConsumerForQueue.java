package local.kapinos.chapter13;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
		mappedName = StartupSingleton.QUEUE_JNDI_NAME, 
		activationConfig = {
//		    @ActivationConfigProperty(
//				    propertyName = "acknowledgeMode", 
//				    propertyValue = "Auto-acknowledge"),
		    @ActivationConfigProperty(
		    		propertyName = "destinationType", 
		    		propertyValue = "javax.jms.Queue") } )// Important for GlassFish
public class MdbConsumerForQueue implements MessageListener {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	private CdiBeanCounter cdiBean;
	
	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct-" + this);
	}

	@PreDestroy
	public void preDestroy() {
		logger.info("@PreDestroy-" + this);
	}

	@Override
	public void onMessage(Message message) {
		logger.info("Call " + this);
		try {
			logger.info("Consumed '" + message.getBody(String.class) + "'");
			cdiBean.incrementReceivedMessagesCountQueue();
		} catch (JMSException e) {

			e.printStackTrace();
		}
	}

}
