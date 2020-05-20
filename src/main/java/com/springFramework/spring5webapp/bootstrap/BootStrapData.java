package com.springFramework.spring5webapp.bootstrap;

import com.springFramework.spring5webapp.domain.Author;
import com.springFramework.spring5webapp.domain.Book;
import com.springFramework.spring5webapp.domain.Publisher;
import com.springFramework.spring5webapp.repositories.AuthorRepository;
import com.springFramework.spring5webapp.repositories.BookRepository;
import com.springFramework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher=new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("Belgrade");
        publisher.setState("Serbia");
        publisher.setZip("11000");
        publisherRepository.save(publisher);

        System.out.println("Number of publishers: "+publisherRepository.count());

        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod=new Author("Rod","Jonson");
        Book noejb=new Book("J2EE developmnet","2323232");
        rod.getBooks().add(noejb);
        noejb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noejb);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: "+bookRepository.count());
    }
}
