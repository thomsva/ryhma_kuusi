package bookmark.bookmark_access;

import bookmark.domain.Bookmark;
import java.util.List;

public interface BookmarkDao {
    
    List<Bookmark> listAll();
    
    //adding add() later?
    //void add(Bookmark bookmark);
}
