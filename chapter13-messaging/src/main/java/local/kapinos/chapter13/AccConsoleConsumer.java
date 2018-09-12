package local.kapinos.chapter13;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageListener;

public class AccConsoleConsumer {

	// We can not @Inject JMSContext directly in ACC
	@Resource(lookup = StartupSingleton.CONNECTION_FACTORY_JNDI_NAME)
	private static ConnectionFactory jmsConnectionFactory;

	@Resource(lookup = StartupSingleton.QUEUE_JNDI_NAME)
	private static Destination jmsDestinationQueue;

	@Resource(lookup = StartupSingleton.TOPIC_JNDI_NAME)
	private static Destination jmsDestinationTopic;

	public static void main(String[] args) throws IOException {
		
		if (jmsConnectionFactory == null)
		{
			System.out.println("This is ACC console application. To run it use");
			System.out.println("glassfish4\\glassfish\\bin>appclient -cp \"<path to folder with class files>\" local.kapinos.chapter13.AccConsoleConsumer");
			System.exit(-1);
		}
				
		MessageListener listener = (message) -> 
		{
			try {
				System.out.println(message.getBody(String.class));
				System.out.flush();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		};
		try(JMSContext jmsContext = jmsConnectionFactory.createContext();
			JMSConsumer c1 = jmsContext.createConsumer(jmsDestinationQueue);// Should be closed, before jmsContext. Otherwise exception
			JMSConsumer c2 = jmsContext.createConsumer(jmsDestinationTopic))
		{		
			c1.setMessageListener(listener);
			c2.setMessageListener(listener);
			
			System.out.println("");
			System.out.println("Waiting for Messgaes");
			System.out.println("For exit press any key");
				
			System.in.read();
		}
	}

}
