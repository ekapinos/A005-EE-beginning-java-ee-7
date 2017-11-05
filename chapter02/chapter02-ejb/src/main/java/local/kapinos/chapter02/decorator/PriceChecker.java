package local.kapinos.chapter02.decorator;

import local.kapinos.chapter02.model.Book;

public interface PriceChecker {
  void checkPrice(Book book);
}
