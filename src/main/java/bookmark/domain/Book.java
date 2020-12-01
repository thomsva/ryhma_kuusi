package bookmark.domain;

/**
 * Representing books.
 */
public class Book extends Bookmark implements Comparable<Bookmark> {
    
    private int id;
    private String author;
    private int numberOfPages;
    private int currentPage;

    /**
     * Create book with specific title.
     *
     * @param newBookTitle
     */
    public Book(final String newBookTitle) {
        super(newBookTitle);
    }

    /**
     * Create book with specific title, author and number of pages.
     *
     * @param newBookTitle
     * @param newAuthor
     * @param newNumberOfPages
     * @param newCurrentPage
     */
    public Book(final String newBookTitle,
            String newAuthor, int newNumberOfPages, int newCurrentPage) {
        super(newBookTitle);
        this.author = newAuthor;
        this.numberOfPages = newNumberOfPages;
        this.currentPage = newCurrentPage;
    }

    public Book(int newId, final String newBookTitle,
            String newAuthor, int newNumberOfPages, int newCurrentPage) {
        super(newBookTitle);
        this.id = newId;
        this.author = newAuthor;
        this.numberOfPages = newNumberOfPages;
        this.currentPage = newCurrentPage;
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

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getId() {
        return id;
    }

}
