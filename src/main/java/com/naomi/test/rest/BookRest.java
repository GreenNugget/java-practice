package com.naomi.test.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naomi.test.models.Book;
import com.naomi.test.services.BookService;

@RestController
public class BookRest {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getLibros(){
        return ResponseEntity.ok().body(bookService.getBooks());
    }

    @PostMapping("/new-book")
    public ResponseEntity<Book> saveBook(@RequestBody Book newBook) throws URISyntaxException{
        Book book = bookService.saveBook(newBook);
        return ResponseEntity.created(new URI("/new-book" + book.getBookId())).body(book);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer bookId, @RequestBody Book updatedBook){
        return ResponseEntity.ok().body(bookService.updateBook(bookId, updatedBook));
    }

    @DeleteMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") Integer bookId){
        bookService.deleteBook(bookId);
        return "Book Deleted Successfully!";
    }
    
}
