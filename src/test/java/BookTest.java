import bookmark.domain.Book;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    
    private Book book;
    
    @Test
    public void createNewBookWithCorrectTitle() {
        book = new Book("ohtu-manual");
        assertEquals("ohtu-manual", book.getTitle());
    }
    
    @Test
    public void createNewBookwithTitleAuthorAndNumberOfPages() {
        book = new Book("title", "author", 1);
        assertEquals("title", book.getTitle());
        assertEquals("author", book.getAuthor());
        assertEquals(1, book.getNumberOfPages());
    }
}
