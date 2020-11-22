
import io.IO;
import java.util.Scanner;


public class App {
    
    private IO io;
    //scanner tarkoitus saada pois tästä luokasta ja luku tapahtumaan io kautta
    private Scanner scanner = new Scanner(System.in);
    
    public App(IO io) {
        this.io = io;
    }
    /**
     * run app
     */
    public void run() {
         
        while (true) {
       
            String command = io.readLine("command (add book or list):");
           
            if (command.isEmpty()) {
                break;
            }
           
            if (command.equals("add book")) {
               
                System.out.println("Book's title: ");
                String bookTitle = scanner.nextLine(); 
               
                System.out.println("Author: ");
                String author = scanner.nextLine();
               
                System.out.println("number of pages: ");
                int pages = Integer.parseInt(scanner.nextLine());
               
                io.print("Added book: " + bookTitle + ", " + author + ", " + pages + " pages.");
                // to do add book to list here
               
            
            } else if (command.equals("list")) {
                System.out.println(" TO DO ");
                
            } else {
                    
               System.out.println("unknown command");
            }
           
            
        }
        
    }
    
        
}
