package bookmark.domain;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BookTest {
    
    private Book book;
    
    @Test
    public void createNewBookWithCorrectTitle() {
        book = new Book("ohtu-manual");
        assertEquals("ohtu-manual", book.getTitle());
    }
    
    @Test
    public void createNewBookwithTitleAuthorNumberOfPagesAndCurrentPageZero() {
        book = new Book("title", "author", 1, 0);
        assertEquals("title", book.getTitle());
        assertEquals("author", book.getAuthor());
        assertEquals(1, book.getNumberOfPages());
        assertEquals(0, book.getCurrentPage());
    }
    
    @Test
    public void setAuthorLaterTest() {
        book = new Book("Crime and Punishment");
        book.setAuthor("Dostoyevsky");
        assertEquals("Dostoyevsky", book.getAuthor());
    }   
    
    @Test
    public void setNonSetAuthorIsNull() {
        book = new Book("Lost in the Andes");
        assertNull(book.getAuthor());
    }
    
    @Test
    public void setNumberOfPagesLater() {
        book = new Book("title", "author", 32, 0);
        book.setNumberOfPages(100);
        assertEquals(100, book.getNumberOfPages());
    }
    
    @Test
    public void setCurrentPageLater() {
        book = new Book("title", "author", 100, 0);
        book.setCurrentPage(32);
        assertEquals(32, book.getCurrentPage());
    }
}
