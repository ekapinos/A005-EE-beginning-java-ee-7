package local.kapinos.chapter02.decorator;

import java.util.logging.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import local.kapinos.chapter02.model.Book;

@Decorator
public class PriceCheckerDecorator implements PriceChecker {

	@Inject
	Logger logger;
	
	@Inject 
	@Delegate
	PriceChecker originalPriceChecker;
	
	@Override
	public void checkPrice(Book book) {
		originalPriceChecker.checkPrice(book);
		
		if (book.getPrice() ==0)
		{
			logger.warning("Checker-decorator: Price is zero");			
		}
		else
		{
			logger.warning("Checker-decorator: Price is non zero");			
		}
	}

}
