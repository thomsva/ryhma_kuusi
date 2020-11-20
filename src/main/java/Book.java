/**
 * Representing books.
 */
public class Book {
    /**
     * Create variable title.
     */
    private String title;
    /**
     * Create book with specific title.
     * @param newBookTitle
     */
    public Book(final String newBookTitle) {
        this.title = newBookTitle;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param newTitle the title to set
     */
    public void setTitle(final String newTitle) {
        this.title = newTitle;
    }
}
