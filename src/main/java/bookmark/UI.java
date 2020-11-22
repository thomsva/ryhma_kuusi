package bookmark;

import bookmark.bookmark_access.InMemoryBookmarkDao;
import java.util.Scanner;

public class UI {
    
    private Scanner s;
    
    public UI(){
        s = new Scanner(System.in);
    }
    
    public void run(){
        
        
        
        while(true){
        
            System.out.println("Quit or list all bookmarks (q/l): ");
            String command = s.nextLine();
        
            if(command.equals("q")) break;
            
            switch (command) {
                case "l":
                    System.out.println(new InMemoryBookmarkDao().listAll());
                    break;
                default:
                    System.out.println("Not a valid command.");
            }
        }
    }
}
