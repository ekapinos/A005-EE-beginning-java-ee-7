package local.kapinos.chapter02.interceptor;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @see local.kapinos.chapter02.services.AbstractBookService
 */
public class BookServiceInterceptor {
	@Inject
	protected Logger logger;

	@AroundConstruct
	public void logConstructor(InvocationContext ic) throws Exception
	{
		logger.log(Level.WARNING, "@AroundConstruct-entering-separate-interceptor-only");
		try {
			ic.proceed();
		} finally {
			logger.log(Level.WARNING, "@AroundConstruct-exiting-separate-interceptor-only");
		}		
	}
	
	@AroundInvoke
	private Object logMethod(InvocationContext ic) throws Exception {
		logger.log(Level.WARNING, "@AroundInvoke-entering-separate-interceptor " + ic.getMethod().getName());
		try {
			return ic.proceed();
		} finally {
			logger.log(Level.WARNING, "@AroundInvoke-exiting-separate-interceptor " + ic.getMethod().getName());
		}
	}
}
