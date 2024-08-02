package com.naomi.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naomi.test.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * This method allows to search books by ID in the DB
     * 
     * @param id from the book we want to find
     * @return a List of books that match the id (in case there are many)
     */
    List<Book> findByBookId(Integer id);
    
    /**
     * This method erases a book that was found by ID
     * 
     * @param id of the book we want to delete
     */
    void deleteById(Integer id);
}