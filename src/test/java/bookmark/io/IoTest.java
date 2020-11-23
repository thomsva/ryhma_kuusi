
package bookmark.io;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.InputStream;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;

public class IoTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
}
    @Test
    public void testPrint() {
        ConsoleIO consoleIO = new ConsoleIO();
        consoleIO.print("hello");
        assertEquals("hello\n", outContent.toString());
            
    }
    
    
    
}
