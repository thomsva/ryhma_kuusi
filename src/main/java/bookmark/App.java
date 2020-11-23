package bookmark;

import bookmark.io.IO;
import bookmark.bookmark_access.InMemoryBookDao;
import bookmark.domain.Book;
import bookmark.bookmark_access.BookDao;
import bookmark.services.BookmarkService;
import bookmark.io.ConsoleIO;

public class App {
    
    private final IO io;
    private BookDao bookDao = new InMemoryBookDao();
    private BookmarkService service;
    
    
    public App(IO io, BookmarkService service) {
        this.io = io;
        this.service = service;
    }
    /**
     * ask book's information from user
     */
    public Book askBookInfo() {
        String title = io.readLine("Book's title: ");
        String author = io.readLine("Author: ");
        int pages = io.readInt("number of pages: ");
        Book book = new Book(title, author, pages);
        return book;
    }
    /**
     * run app
     */
    public void run() {
         
        while (true) {
            
            System.out.println("");
            String command = io.readLine("command ('add book' or 'list') or leave empty to quit:");
           
            if (command.isEmpty()) {
                break;
            }
           
            if (command.equals("add book")) {
               
                Book newBook = askBookInfo();
               
                if (service.addBook(newBook)) {
                    io.print("Book added successfully");
                    
                } else {
                    io.print("Error in adding the bookmark");                     
                } 
                
            } else if (command.equals("list")) {
                
                service.listBooks();
                    
            } else {
               System.out.println("unknown command");
            }
        }
    }
    public static void main(String[] args) {
        
        IO io = new ConsoleIO();
        BookDao dao = new InMemoryBookDao();
        BookmarkService service = new BookmarkService(dao);  
        System.out.println("Welcome to BookMarkApp!");
        new App(io, service).run();
   
    }
}

