package local.kapinos.chapter02.services;

import java.util.logging.Level;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;

import local.kapinos.chapter02.annotations.ThirteenDigits;
import local.kapinos.chapter02.interceptor.BookServiceInterceptor;

/**
 * Double intercepting
 *
 */
@Interceptors(BookServiceInterceptor.class)
public class BookService extends AbstractBookService {

	@Inject
	public BookService(@ThirteenDigits NumberGenerator numberGenerator) {
		super(numberGenerator);
	}
		
	/**
	 * @see local.kapinos.chapter02.interceptor.BookServiceInterceptor
	 */
	@AroundInvoke
	private Object logMethod(InvocationContext ic) throws Exception {
		logger.log(Level.WARNING, "@AroundInvoke-entering-inner-interceptor " + ic.getMethod().getName());
		try {
			return ic.proceed();
		} finally {
			logger.log(Level.WARNING, "@AroundInvoke-exiting-inner-interceptor " + ic.getMethod().getName());
		}
	}

}