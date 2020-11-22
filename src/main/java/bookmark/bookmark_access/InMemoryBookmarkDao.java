package bookmark.bookmark_access;

import bookmark.domain.Bookmark;
import java.util.List;

public class InMemoryBookmarkDao implements BookmarkDao {
    
    private List<Bookmark> bookmarks;
    
    /**
     * @return the list containing all bookmarks
     */
    @Override
    public List<Bookmark> listAll() {
        return bookmarks;
    }    
}
