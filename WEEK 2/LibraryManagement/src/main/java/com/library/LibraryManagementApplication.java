package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // 1. Initialize Spring IoC container from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Retrieve the BookService bean (which already has BookRepository injected into it)
        BookService bookService = (BookService) context.getBean("bookService");

        // 3. Verify the dependency injection
        System.out.println("Starting Library Management Application...");
        bookService.performServiceTask();
    }
}
