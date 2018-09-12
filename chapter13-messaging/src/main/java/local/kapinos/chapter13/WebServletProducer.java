package local.kapinos.chapter13;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSSessionMode;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/produce/*")
@SuppressWarnings("serial")
public class WebServletProducer extends HttpServlet {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Inject
	@JMSConnectionFactory(StartupSingleton.CONNECTION_FACTORY_JNDI_NAME)
	@JMSSessionMode(JMSContext.AUTO_ACKNOWLEDGE)
	private JMSContext jmsContext;
	
	@Resource(lookup = StartupSingleton.QUEUE_JNDI_NAME)
	private Destination jmsDestinationQueue;
	
	@Resource(lookup = StartupSingleton.TOPIC_JNDI_NAME)
	private Destination jmsDestinationTopic;
	
	@Inject
	private CdiBeanCounter produceCounterCdiBean;

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this); 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Call " + this);
		
		Destination jmsDestination;
		Runnable incrementMethod;
		if (req.getRequestURI().endsWith("queue"))
		{
			jmsDestination = jmsDestinationQueue;
			incrementMethod = produceCounterCdiBean::incrementSentMessagesCountQueue;
			
		}
		else if (req.getRequestURI().endsWith("topic"))
		{
			jmsDestination = jmsDestinationTopic;
			incrementMethod = produceCounterCdiBean::incrementSentMessagesCountTopic;
		}		
		else
		{
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		jmsContext.createProducer().send(jmsDestination, "Message "+ (new Date()));

		incrementMethod.run();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath());
	}
}
