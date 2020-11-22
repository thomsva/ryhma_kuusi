package bookmark;

import io.IO;
import java.util.Scanner;
import bookmark.bookmark_access.InMemoryBookDao;
import bookmark.domain.Book;
import bookmark.bookmark_access.BookDao;
import java.util.List;

public class App {
    
    private final IO io;
    private BookDao bookDao = new InMemoryBookDao();
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
       
            String command = io.readLine("command ('add book' or 'list') or leave empty to quit:");
           
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
               
                try { 
                    Book book = new Book(bookTitle, author, pages);
                    bookDao.add(book);
                    io.print("Added book: " + bookTitle + ", " + author + ", " + pages + " pages.");
                } catch (Exception e) {
                    System.out.println("Error in adding the bookmark.");
                    System.out.println(e);
                }
                
            } else if (command.equals("list")) {
                
                List<Book> booklist = bookDao.listAll();
                booklist.forEach((book) -> {
                    System.out.println("Title: " + book.getTitle()
                            + " | Author: " + book.getAuthor()
                            + " | Number of pages: " + book.getNumberOfPages());
                });
               
            } else {
               System.out.println("unknown command");
            }
        }
    }
}
