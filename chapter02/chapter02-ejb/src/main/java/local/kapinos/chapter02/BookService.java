package local.kapinos.chapter02;

import javax.inject.Inject;

public class BookService extends AbstractBookService {

	@Inject
	public BookService(@ThirteenDigits NumberGenerator numberGenerator) {
		super(numberGenerator);
	}

}