package bookmark.bookmark_access;

import org.junit.Test;
import org.junit.Before;
import bookmark.domain.Book;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author blakaut
 */
public class InMemoryBookDaoTest {
    
        private Book book, book2;
    private BookDao bookDao;
    
    @Before
    public void setup() {
        book = new Book("Lost in the Andes!", "Carl Barks", 32, 0);
        this.bookDao = new InMemoryBookDao();
    }
    
    @Test
    public void addBookTest() {
        bookDao.add(book);
        assertEquals(bookDao.listAll().get(0).getAuthor(), "Carl Barks");
    }
    
    @Test
    public void addWithTitleOnlyTest() {
        this.book2 = new Book("Title only");
        bookDao.add(book2);
        assertNull(bookDao.listAll().get(0).getAuthor());
    }    
}
