/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmark.services;

import bookmark.bookmark_access.BookDao;
import bookmark.domain.Book;
import java.util.Collections;
import java.util.List;
import bookmark.io.IO;

/**
 *
 * @author iida
 */
public class BookmarkService {
    
    private final IO io;
    private BookDao bookDao;
    
    public BookmarkService(BookDao bookDao, IO io) {
        this.bookDao = bookDao;
        this.io = io;
    }
     /**
     * calls BookDao's method add to add book
     * @param inputTitle title user entered
     * @param inputAuthor author user entered 
     * @param inputPages pages user entered
     * @return return true if inputs were valid and book was added, otherwise false
     */
    public boolean addBook(String inputTitle, String inputAuthor, String inputPages) {
        
        String regex = "^[0-9]+";
        
        if (!inputPages.matches(regex)) {
            return false;
        } else if (isBlankOrEmprty(inputTitle, inputAuthor, inputPages)) {
            return false;
        } else {
            int pages = Integer.parseInt(inputPages);
            Book book = new Book(inputTitle, inputAuthor, pages, 0);
            bookDao.add(book);
        
        return true;
        }

    }
     /**
     * calls BookDao's method listAll to list books
     */
    public void listBooks() {
       List<Book> bookList = bookDao.listAll();
       Collections.sort(bookList);
       bookList.forEach((book) -> {
                    io.print("Id: " + book.getId()
                            + " | Title: " + book.getTitle()
                            + " | Author: " + book.getAuthor()
                            + " | Number of pages: " + book.getNumberOfPages()
                            + " | Current page: " + book.getCurrentPage());
                });
    }
    
    private boolean isBlankOrEmprty(String inputTitle, String inputAuthor, String inputPages) {
        if (inputTitle.trim().isEmpty() || inputTitle.trim().isBlank()) {
            return true;
        } else if (inputAuthor.trim().isEmpty() || inputAuthor.trim().isBlank()) {
            return true;
        } else {
            return inputPages.trim().isEmpty() || inputPages.trim().isBlank();
        }
    }
    
    
}
