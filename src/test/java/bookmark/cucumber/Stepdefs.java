
package bookmark.cucumber;

import bookmark.App;
import bookmark.bookmark_access.BookDao;
import bookmark.bookmark_access.InMemoryBookDao;
import bookmark.io.StubIO;
import bookmark.services.BookmarkService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
        


public class Stepdefs {
    
    private BookDao bookDao;
    private App app;
    private List<String> inputLines;
    private BookmarkService service;
    private StubIO io;
    
    @Before
    public void setUp() {
        bookDao = new InMemoryBookDao();   
        inputLines = new ArrayList<>();  
        service = new BookmarkService(bookDao);
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
        io = new StubIO(inputLines); 
        app = new App(io, service);
        app.run();
    }
    
    @When("valid title {string} and author {string} and invalid pages {string} are entered")
    public void validTitleAuthorAndInvalidPagesAreEntered(String title, String author, String pages) {
        inputLines.add(title);
        inputLines.add(author);
        inputLines.add(pages);
        io = new StubIO(inputLines); 
        app = new App(io, service);
        app.run();
    }
    
    @When("invalid title {string} and  valid author {string} and valid pages {string} are entered")
    public void invalidTitleValidAuthorAndValidPagesAreEntered(String title, String author, String pages) {
        inputLines.add(title);
        inputLines.add(author);
        inputLines.add(pages);
        io = new StubIO(inputLines); 
        app = new App(io, service);
        app.run();
    }
    
    @Then("system will respond with {string}")
    public void systemRespondsWithExpectedOutput(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

}


        
 