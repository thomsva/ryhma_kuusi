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
            String command = io.readLine("command ('add book', 'list' or 'modpage') or leave empty to quit:");

            if (command.isEmpty()) {
                break;
            }

            switch (command) {
                case "add book":
                    String title = io.readLine("Book's title: ");
                    String author = io.readLine("Author: ");
                    String pages = io.readLine("Number of pages: ");
                    String currentPage = io.readLine("Page you're currently on: ");
                    if (service.addBook(title, author, pages, currentPage)) {
                        io.print("Book added successfully");

                    } else {
                        io.print("Error in adding the bookmark");
                    }
                    break;
                case "list":
                    service.listBooks();
                    break;
                case "modpage":
                    String id = io.readLine("Book's id (empty to return):");
                    if (id.equals("")) break;
                    String page = io.readLine("Page you are currently on (empty to return):");
                    if (page.equals("")) break;
                    io.print(service.modifyCurrentPage(id, page));
                    break;
                default:
                    io.print("unknown command");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        IO io = new ConsoleIO();

        BookDao dbDao = new DBDao("bookmark.db");
        BookmarkService service = new BookmarkService(dbDao, io);
        System.out.println("Welcome to BookMarkApp!");
        new App(io, service).run();
    }

}