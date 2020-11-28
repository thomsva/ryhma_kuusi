
package bookmark.cucumber;

import bookmark.App;
import bookmark.bookmark_access.BookDao;
import bookmark.bookmark_access.DBDao;
import bookmark.io.StubIO;
import bookmark.services.BookmarkService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertTrue;

public class Stepdefs {
    
    private BookDao bookDao;
    private App app;
    private List<String> inputLines;
    private BookmarkService service;
    private StubIO io;
    
    @Before
    public void setUp() {
        bookDao = new DBDao("cucumberTest.db");   
        inputLines = new ArrayList<>();  
    }
    
    @After
    public void tearDown() {
        File file = new File("cucumberTest.db");
        file.deleteOnExit();
    }
    
    @Given("command add book is selected")
    public void commandAddBookSelected() {
        inputLines.add("add book");
    }
    
    @When("valid title {string} and author {string} and pages {string} are entered")
    public void validTitleAuthorAndPagesAreEntered(String title, String author, String pages) {
        inputLines.add(title);
        inputLines.add(author);
        inputLines.add(pages);
        runApp();
    }
    
    @When("valid title {string} and author {string} and invalid pages {string} are entered")
    public void validTitleAuthorAndInvalidPagesAreEntered(String title, String author, String pages) {
        inputLines.add(title);
        inputLines.add(author);
        inputLines.add(pages);
        runApp();
    }
    
    @When("invalid title {string} and  valid author {string} and valid pages {string} are entered")
    public void invalidTitleValidAuthorAndValidPagesAreEntered(String title, String author, String pages) {
        inputLines.add(title);
        inputLines.add(author);
        inputLines.add(pages);
        runApp();
    }
    
    @Then("system will respond with {string}")
    public void systemRespondsWithExpectedOutput(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @Given("create book title {string}, author {string} and pages {string}")
    public void createBooks(String title, String author, String pages) {
        inputLines.add(title);
        inputLines.add(author);
        inputLines.add(pages);
    }

    @When("command list is selected")
    public void commandListIsSelected() {
        inputLines.add("list");
        runApp();
    }

    @When("command {string} is selected")
    public void customCommandSelected(String command) {
        inputLines.add(command);
        runApp();
    }
    
    private void runApp() {
        io = new StubIO(inputLines); 
        service = new BookmarkService(bookDao, io);
        app = new App(io, service);
        app.run();
    }

}
