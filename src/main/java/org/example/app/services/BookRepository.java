/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.app.services;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.example.web.controllers.BookShelfController;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mak
 */

@Repository
public class BookRepository implements ProjectRepository<Book>{
    
    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList();
    
    @Override
    public List<Book> retriveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        if (book.getAuthor().isEmpty() && book.getTitle().isEmpty()){
            logger.info("No info for store book");
        }
        book.setId(book.hashCode());
        logger.info("store new book: "+book);
        repo.add(book);
    }
    
}
