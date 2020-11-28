package bookmark;

import bookmark.io.IO;
//import bookmark.bookmark_access.InMemoryBookDao;
import bookmark.bookmark_access.BookDao;
import bookmark.bookmark_access.DBDao;
import bookmark.services.BookmarkService;
import bookmark.io.ConsoleIO;

public class App {

    private final IO io;
    private final BookmarkService service;

    public App(IO io, BookmarkService service) {
        this.io = io;
        this.service = service;
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

            switch (command) {
                case "add book":
                    String title = io.readLine("Book's title: ");
                    String author = io.readLine("Author: ");
                    String pages = io.readLine("number of pages: ");
                    if (service.addBook(title, author, pages)) {
                        io.print("Book added successfully");
                        
                    } else {
                        io.print("Error in adding the bookmark");
                    }   break;
                case "list":
                    service.listBooks();
                    break;
                case "modpage":
                    int id = io.readInt("id:");
                    int page = io.readInt("page:");
                    service.modifyCurrentPage(id, page);
                    break;
                default:
                    System.out.println("unknown command");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        IO io = new ConsoleIO();
        //Boolean dbMemory = true;
        /*if (!dbMemory) {
            BookDao dao = new InMemoryBookDao();
            BookmarkService service = new BookmarkService(dao);
            System.out.println("Welcome to BookMarkApp!");
            new App(io, service).run();
        } else {
         */
        BookDao dbDao = new DBDao("bookmark.db");
        BookmarkService service = new BookmarkService(dbDao);
        System.out.println("Welcome to BookMarkApp!");
        new App(io, service).run();

        //}
    }
}