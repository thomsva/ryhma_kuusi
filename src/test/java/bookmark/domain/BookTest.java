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
    public void createNewBookwithTitleAuthorAndNumberOfPages() {
        book = new Book("title", "author", 1, 0);
        assertEquals("title", book.getTitle());
        assertEquals("author", book.getAuthor());
        assertEquals(1, book.getNumberOfPages());
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
    
}
