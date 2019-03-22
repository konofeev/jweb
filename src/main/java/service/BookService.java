package service;

import entity.Book;
import inject.NumberGenerator;
import inject.ThirteenDigits;
import javax.inject.Inject;
import log.Loggable;

@Loggable
public class BookService
{
    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String description)
    {
        System.out.println("create Book begin");
        Book book = new Book(title, price, description);
        System.out.println("create Book process");
        System.out.println("numberGenerator: '" + numberGenerator + "'");
        book.setNumber(numberGenerator.generateNumber());
        System.out.println("create Book end");
        return book;
    }
}
