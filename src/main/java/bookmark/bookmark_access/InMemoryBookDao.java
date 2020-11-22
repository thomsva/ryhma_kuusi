package bookmark.bookmark_access;

import bookmark.domain.Book;
import java.util.ArrayList;
import java.util.List;

public class InMemoryBookDao implements BookDao {
    
    private List<Book> books = new ArrayList<>();
    
    public InMemoryBookDao() {
        books = new ArrayList<>();
    } 
    
    /**
     * @return the list containing all bookmarks
     */
    @Override
    public List<Book> listAll() {
        return books;
    }
    
    @Override
    public void add(Book book){
        books.add(book);
    }
}
