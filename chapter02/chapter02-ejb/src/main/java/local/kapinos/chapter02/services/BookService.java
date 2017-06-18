package local.kapinos.chapter02.services;

import javax.inject.Inject;

import local.kapinos.chapter02.annotations.ThirteenDigits;

public class BookService extends AbstractBookService {

	@Inject
	public BookService(@ThirteenDigits NumberGenerator numberGenerator) {
		super(numberGenerator);
	}

}