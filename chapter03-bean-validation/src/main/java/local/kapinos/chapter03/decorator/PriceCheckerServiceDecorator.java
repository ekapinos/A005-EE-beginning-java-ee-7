package local.kapinos.chapter03.decorator;

import java.util.logging.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import local.kapinos.chapter03.model.Book;

@Decorator
public class PriceCheckerServiceDecorator implements PriceCheckerService {

	@Inject
	Logger logger;
	
	@Inject 
	@Delegate
	PriceCheckerService originalPriceChecker;
	
	@Override
	public void checkPrice(Book book) {
		originalPriceChecker.checkPrice(book);
		
		if (book.getPrice() ==0)
		{
			logger.warning("@Decorator-wrap: Price is zero");			
		}
		else
		{
			logger.warning("@Decorator-wrap: Price is non zero");			
		}
	}

}
