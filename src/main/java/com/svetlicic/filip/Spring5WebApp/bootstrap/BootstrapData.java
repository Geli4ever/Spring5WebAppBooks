package com.svetlicic.filip.Spring5WebApp.bootstrap;

import com.svetlicic.filip.Spring5WebApp.domain.Author;
import com.svetlicic.filip.Spring5WebApp.domain.Book;
import com.svetlicic.filip.Spring5WebApp.domain.Publisher;
import com.svetlicic.filip.Spring5WebApp.repositories.AuthorRepository;
import com.svetlicic.filip.Spring5WebApp.repositories.BookRepository;
import com.svetlicic.filip.Spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher amazon = new Publisher("Amazon", "Zagrebacka cesta 224, 10090, Zagreb");
        publisherRepository.save(amazon);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(amazon);
        amazon.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(amazon);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "45476583");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(amazon);
        amazon.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(amazon);

        System.out.println("Started in bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());





        System.out.println("Count of publishers: " + publisherRepository.count());
        System.out.println("Publisher Number of Books: " + amazon.getBooks().size());
    }
}
