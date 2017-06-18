package local.kapinos.chapter02.producers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

// We need any bean for dispose. Otherwise next will appear in a log:
// Severe: No valid EE environment for injection of local.kapinos.chapter02.producers.LoggingProducer
@ApplicationScoped
public class LoggingProducer {

	@Produces
	public Logger createLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
	
	public void disposeLogger(@Disposes Logger logger)
	{
		logger.log(Level.WARNING, "disposeLogger " + logger.getName());
	}
}