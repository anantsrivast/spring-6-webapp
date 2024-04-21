package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.bookRepository=bookRepository;
        this.authorRepository=authorRepository;
        this.publisherRepository=publisherRepository;

    }
    public void run(String... args) throws Exception {
        Author eric= new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        Book ddd= new Book();
        ddd.setTitle("DDD");
        ddd.setIsbn("123456");
        Publisher toaks=new Publisher();
        toaks.setPublisherAddress("asss");
        toaks.setPublisherName("haha");
        Publisher toaksSaved= publisherRepository.save(toaks);
        ddd.setPublisher(toaksSaved);
        Author ericSaved= authorRepository.save(eric);
        Book dddSaved= bookRepository.save(ddd);
        ericSaved.getBooks().add(dddSaved);
        dddSaved.getAuthors().add(ericSaved);

        authorRepository.save(ericSaved);
        bookRepository.save(dddSaved);

        System.out.println("Book Count "  +  bookRepository.count() );
        System.out.println("Pub Count "  +  publisherRepository.count());

    }


}
