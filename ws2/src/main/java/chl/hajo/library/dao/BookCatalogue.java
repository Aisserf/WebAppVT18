package chl.hajo.library.dao;


import chl.hajo.library.core.Book;
import chl.hajo.library.service.BookSupplier;
import java.util.List;
import javax.ejb.Stateless;

/**
 * All orders Responsible for putting new PurchaseOrders objects into the model
 *
 * @author hajo
 */
@Stateless
public class BookCatalogue  {
    private final List<Book> books = BookSupplier.getBooks();
    
    public List<Book> findByName(String name) {
        return null;
    }
    
    public Book find(String isbn) {
        for(Book b: books) {
            if(b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }
    
    public List<Book> findAll() {
        return books;
    }
 
    public void create(Book book){
        books.add(book);
    }
    
    public void update(Book book){
        delete(book.getIsbn());
        create(book);
    }
    
    public void delete(String isbn){
        Book b = find(isbn);
        if(b != null){
            books.remove(b);
        }
    }
   
}
