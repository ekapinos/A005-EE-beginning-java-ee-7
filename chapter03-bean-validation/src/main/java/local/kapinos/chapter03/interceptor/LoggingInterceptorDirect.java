package local.kapinos.chapter03.interceptor;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @see local.kapinos.chapter03.services.AbstractBookService
 */
public class LoggingInterceptorDirect {
	@Inject
	protected Logger logger;

	@AroundConstruct
	public void logConstructor(InvocationContext ic) throws Exception
	{
		logger.warning(getClass().getSimpleName() + " @AroundConstruct-entering-separate-interceptor-only");
		try {
			ic.proceed();
		} finally {
			logger.warning(getClass().getSimpleName() + " @AroundConstruct-exiting-separate-interceptor-only");
		}		
	}
	
	@AroundInvoke
	private Object logMethod(InvocationContext ic) throws Exception {
		logger.warning(getClass().getSimpleName() + " @AroundInvoke-entering-separate-interceptor " + ic.getMethod().getName());
		try {
			return ic.proceed();
		} finally {
			logger.warning(getClass().getSimpleName() + " @AroundInvoke-exiting-separate-interceptor " + ic.getMethod().getName());
		}
	}
}
