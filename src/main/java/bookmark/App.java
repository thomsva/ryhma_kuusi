package bookmark;

import bookmark.io.IO;
import bookmark.bookmark_access.InMemoryBookDao;
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

            if (command.equals("add book")) {

                String title = io.readLine("Book's title: ");
                String author = io.readLine("Author: ");
                String pages = io.readLine("number of pages: ");

                if (service.addBook(title, author, pages)) {
                    io.print("Book added successfully");

                } else {
                    io.print("Error in adding the bookmark");
                }

            } else if (command.equals("list")) {

                service.listBooks();

            } else {
                io.print("unknown command");
            }
        }
    }

    public static void main(String[] args) {
        IO io = new ConsoleIO();
        Boolean dbMemory = true;
        if (!dbMemory) {
            BookDao dao = new InMemoryBookDao();
            BookmarkService service = new BookmarkService(dao, io);
            System.out.println("Welcome to BookMarkApp!");
            new App(io, service).run();
        } else {
            BookDao dbDao = new DBDao("bookmark.db");
            BookmarkService service = new BookmarkService(dbDao, io);
            System.out.println("Welcome to BookMarkApp!");
            new App(io, service).run();
        }
    }
}
