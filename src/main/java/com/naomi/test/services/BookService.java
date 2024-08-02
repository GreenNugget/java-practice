package com.naomi.test.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naomi.test.models.Book;
import com.naomi.test.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    /**
     * This method allows to get all the books from the DB
     * 
     * @return a List with all the books in the DB
     */
    public List<Book> getBooks(){
        List<Book> books = new LinkedList<>();
        bookRepository.findAll().iterator().forEachRemaining(books::add);
        return books;
    }

    /**
     * This method creates a new Book
     * 
     * @param book a Book object
     * @return the attributes of the new book
     */
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    /**
     * This method allows to update an existing book in the DB
     * 
     * @param bookId of the book we want to update
     * @param updatedBook the Book object that contains the updated attributes
     * @return the updated book
     */
    public Book updateBook(Integer bookId, Book updatedBook){
        Book reference = bookRepository.findByBookId(bookId).get(0);

        reference.setTitle(updatedBook.getTitle());
        reference.setDescription(updatedBook.getDescription());
        reference.setAuthor(updatedBook.getAuthor());
        reference.setCover(updatedBook.getCover());

        return reference;
    }

    /**
     * This method erases a book from the DB
     * 
     * @param id from the book we want to delete
     */
    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }
    
}
