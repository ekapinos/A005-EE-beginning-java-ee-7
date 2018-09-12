package local.kapinos.chapter13;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;

public class AccConsoleProducer {

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
			System.out.println("glassfish4\\glassfish\\bin>appclient -cp \"<path to folder with class files>\" local.kapinos.chapter13.AccConsoleProducer");
			System.exit(-1);
		}
		
		
		try (JMSContext jmsContext = jmsConnectionFactory.createContext(); 
		     Scanner scanner = new Scanner(System.in))
		{
			JMSProducer producer = jmsContext.createProducer();
			
			System.out.println("");
			System.out.println("To produce Queue Message press '1'");
			System.out.println("To produce Topic Message press '2'");
			System.out.println("For exit press q");
			
			System.out.print(">");
			
			readNextCommand: while (scanner.hasNext()) 
			{
				String command = scanner.nextLine();
				Destination jmsDestination;
				switch(command)
				{
					case "1":
						System.out.print("Queue Message\n>");
						jmsDestination = jmsDestinationQueue;
						break;
					case "2":
						System.out.print("Topic Message\n>");
						jmsDestination = jmsDestinationTopic;
						break;
					case "q":
						System.out.println("Quit");
						return;
					default:
						System.out.print("Unknown command "+command +"\n>");
						continue readNextCommand;
				}
				
				producer.send(jmsDestination, "ACC Message "+ (new Date()));			 
			}
		}	
	}
}
