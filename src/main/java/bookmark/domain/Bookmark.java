package bookmark.domain;



public class Bookmark implements Comparable<Bookmark> {
    
    private String title;

    public Bookmark(String newBookTitle) {
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

    @Override
    public int compareTo(Bookmark o) {
        return this.getTitle().toLowerCase().compareTo(o.getTitle().toLowerCase());
    }
    
}
