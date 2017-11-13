package local.kapinos.chapter03.decorator;

import java.util.logging.Logger;

import javax.inject.Inject;

import local.kapinos.chapter03.model.Book;

public class PriceCheckerServiceImpl implements PriceCheckerService {

	@Inject
	Logger logger;
	
	@Override
	public void checkPrice(Book book) {
		
		if (book.getPrice() < 0)
		{
			logger.warning("@Decorator-impl: Price is less than zero");
		}
		else
		{
			logger.warning("@Decorator-impl: Price is OK");			
		}
	}

}
