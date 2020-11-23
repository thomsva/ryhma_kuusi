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
     */
    public boolean addBook(Book book) {
        
        bookDao.add(book);
        
        return true;
    }
     /**
     * calls BookDao's method listAll to list books
     */
    public void listBooks() {
       List<Book> bookList = bookDao.listAll();
       
       bookList.forEach((book) -> {
                    System.out.println("Title: " + book.getTitle()
                            + " | Author: " + book.getAuthor()
                            + " | Number of pages: " + book.getNumberOfPages());
                });
    }
    
    
}

