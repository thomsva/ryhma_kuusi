package bookmark.domain;

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
        super(newBookTitle);
    }
    
    /**
     * Create book with specific title, author and number of pages.
     * @param newBookTitle
     * @param newAuthor
     * @param newNumberOfPages
     */
    public Book(final String newBookTitle, 
            String newAuthor, int newNumberOfPages) {
        super(newBookTitle);
        this.author = newAuthor;
        this.numberOfPages = newNumberOfPages;
    }

    /**
     * @param newAuthor the author to set
     */
    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    /**
     * @param newNumberOfPages the number of pages to set
     */
    public void setNumberOfPages(int newNumberOfPages) {
        this.numberOfPages = newNumberOfPages;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the number of pages
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }
    
}
