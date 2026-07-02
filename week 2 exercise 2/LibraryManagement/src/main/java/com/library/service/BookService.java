package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;

    // Setter for dependency injection via XML configuration
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void performServiceTask() {
        System.out.println("BookService is working... processing request.");
        
        // Ensure that the repository was properly injected
        if (bookRepository != null) {
            bookRepository.performRepositoryTask();
        } else {
            System.out.println("BookRepository is NOT injected!");
        }
    }
}
