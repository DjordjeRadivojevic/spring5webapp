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

        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod=new Author("Rod","Jonson");
        Book noejb=new Book("J2EE developmnet","2323232");
        rod.getBooks().add(noejb);
        noejb.getAuthors().add(rod);

        noejb.setPublisher(publisher);
        publisher.getBooks().add(noejb);

        authorRepository.save(rod);
        bookRepository.save(noejb);
        publisherRepository.save(publisher);

        System.out.println("Started in bootstrap");
        System.out.println("Number of publishers: "+publisherRepository.count());
        System.out.println("Number of books: "+bookRepository.count());
        System.out.println("Publishers number of books: "+publisher.getBooks().size());

    }
}
