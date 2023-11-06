package pl.edu.pg.student.AUI.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.student.AUI.author.repository.api.AuthorRepository;
import pl.edu.pg.student.AUI.book.entity.Book;
import pl.edu.pg.student.AUI.book.repository.api.BookRepository;
import pl.edu.pg.student.AUI.book.service.api.BookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookDefaultService implements BookService {

    private final BookRepository repository;

    private final AuthorRepository authorRepository;

    @Autowired
    public BookDefaultService(BookRepository repository, AuthorRepository authorRepository){
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Book> find(UUID id){
        return repository.findById(id);
    }

    @Override
    public Optional<List<Book>> findAllByAuthor(UUID authorId){
        return authorRepository.findById(authorId)
                .map(repository::findAllByAuthor);
    }

    @Override
    public List<Book> findAll(){
        return repository.findAll();
    }

    @Override
    public void create(Book book){
        repository.save(book);
    }

    @Override
    public void update(Book book){
        repository.save(book);
    }

    @Override
    public void delete(UUID id){
        repository.findById(id).ifPresent(repository::delete);
    }

}
