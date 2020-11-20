import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    
    private Book book;
    
    @Test
    public void createNewBookWithCorrectTitle() {
        book = new Book("ohtu-manual");
        assertEquals("ohtu-manual", book.getTitle());
    }
}
