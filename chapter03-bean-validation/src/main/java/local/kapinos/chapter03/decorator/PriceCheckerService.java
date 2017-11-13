package local.kapinos.chapter03.decorator;

import local.kapinos.chapter03.model.Book;

public interface PriceCheckerService {
  void checkPrice(Book book);
}
