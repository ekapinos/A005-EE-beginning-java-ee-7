package local.kapinos.chapter03.interceptor;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * "Binding" interceptors have to be enabled in beans.xml
 * 
 * @see local.kapinos.chapter03.services.AbstractBookService
 */
@Interceptor
@Loggable
@Priority(Interceptor.Priority.LIBRARY_BEFORE + 10)
public class loggingInterceptorBinding {
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
