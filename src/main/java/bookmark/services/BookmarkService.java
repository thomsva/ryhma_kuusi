/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmark.services;

import bookmark.bookmark_access.BookDao;
import bookmark.domain.Book;
import java.util.List;

/**
 *
 * @author iida
 */
public class BookmarkService {

    private BookDao bookDao;

    public BookmarkService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * calls BookDao's method add to add book
     *
     * @param inputTitle title user entered
     * @param inputAuthor author user entered
     * @param inputPages pages user entered
     * @return return true if inputs were valid and book was added, otherwise
     * false
     */
    public boolean addBook(String inputTitle, String inputAuthor, String inputPages) {

        String regex = "^[0-9]+";

        if (!inputPages.matches(regex)) {
            return false;
        } else if (inputTitle.isEmpty() || inputAuthor.isEmpty() || inputPages.isEmpty()) {
            return false;
        } else {
            int pages = Integer.parseInt(inputPages);
            Book book = new Book(inputTitle, inputAuthor, pages, 0);
            bookDao.add(book);

            return true;
        }
    }

    public void modifyCurrentPage(int id, int page) {
        bookDao.modifyCurrentPage(id, page);
    }

    /**
     * calls BookDao's method listAll to list books
     */
    public void listBooks() {
        List<Book> bookList = bookDao.listAll();

        bookList.forEach((book) -> {
            System.out.println("Id: " + book.getId()
                    + " | Title: " + book.getTitle()
                    + " | Author: " + book.getAuthor()
                    + " | Number of pages: " + book.getNumberOfPages()
                    + " | Current page: " + book.getCurrentPage());
        });
    }
}
