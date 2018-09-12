package local.kapinos.chapter13;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;


@JMSConnectionFactoryDefinition(
		name = StartupSingleton.CONNECTION_FACTORY_JNDI_NAME, 
		className = "javax.jms.ConnectionFactory")

@JMSDestinationDefinitions(value = {
		@JMSDestinationDefinition(
				name = StartupSingleton.QUEUE_JNDI_NAME, 
				interfaceName = "javax.jms.Queue",
				destinationName = "exampleTopic" // Need to be set for GlassFish
				),
		@JMSDestinationDefinition(
				name = StartupSingleton.TOPIC_JNDI_NAME, 
				interfaceName = "javax.jms.Topic",
				destinationName = "exampleTopic" // Need to be set for GlassFish
				) })

@Singleton
@Startup
public class StartupSingleton {

	public static final String CONNECTION_FACTORY_JNDI_NAME = "java:global/example_connectionFactory";
	public static final String QUEUE_JNDI_NAME = "java:global/example_queue"; // NAme prefix is important for GlassFish
	public static final String TOPIC_JNDI_NAME = "java:global/example_topic";

	private Logger logger = Logger.getLogger(getClass().getName());

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct-" + this);
	}

	@PreDestroy
	public void preDestroy() {
		logger.info("@PreDestroy-" + this);
	}
}