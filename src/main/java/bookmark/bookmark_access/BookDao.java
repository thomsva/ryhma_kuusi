package bookmark.bookmark_access;

import bookmark.domain.Book;
import java.util.List;

public interface BookDao {
    
    List<Book> listAll();
    void add(Book book);
    
}
