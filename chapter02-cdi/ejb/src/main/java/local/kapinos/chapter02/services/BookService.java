package local.kapinos.chapter02.services;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;

import local.kapinos.chapter02.interceptor.Loggable;
import local.kapinos.chapter02.interceptor.LoggingInterceptorDirect;
import local.kapinos.chapter02.qualifier.ThirteenDigits;

/**
 * Double intercepting
 *
 */
@Interceptors(LoggingInterceptorDirect.class) // Intercepter Type 1
@Loggable                                     // Intercepter Type 2
public class BookService extends AbstractBookService {

	@Inject
	public BookService(@ThirteenDigits NumberGenerator numberGenerator) {
		super(numberGenerator);
	}
	
	// Intercepter Type 3
	/**
	 * @see local.kapinos.chapter02.interceptor.LoggingInterceptorDirect
	 */
	@AroundInvoke
	private Object logMethod(InvocationContext ic) throws Exception {
		logger.warning(getClass().getSimpleName() +  " @AroundInvoke-entering-inner-interceptor " + ic.getMethod().getName());
		try {
			return ic.proceed();
		} finally {
			logger.warning(getClass().getSimpleName() +  " @AroundInvoke-exiting-inner-interceptor " + ic.getMethod().getName());
		}
	}

}