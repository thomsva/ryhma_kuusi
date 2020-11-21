/**
 * Representing books.
 */
public class Book extends Bookmark {
    
    private String author; 
    private int numberOfPages;
    
    /**
     * Create book with specific title.
     * @param newBookTitle
     */
    public Book(final String newBookTitle) {
        this.title = newBookTitle;
    }
    
    /**
     * Create book with specific title, author and number of pages.
     * @param newBookTitle
     * @param author
     * @param numberOfPages
     */
    public Book(String newBookTitle, String author, int numberOfPages) {
        this.title = newBookTitle;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

}
