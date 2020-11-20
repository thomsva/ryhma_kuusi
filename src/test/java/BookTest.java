import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    
    Book book;
    
    @Test
    public void createNewBookWithCorrectTitle() {
        book = new Book("ohtu-manual");
        assertEquals("ohtu-manual", book.getTitle());
    }
}
