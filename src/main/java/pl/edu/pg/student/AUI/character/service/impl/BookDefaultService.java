package pl.edu.pg.student.AUI.character.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.student.AUI.character.entity.Book;
import pl.edu.pg.student.AUI.character.repository.api.AuthorRepository;
import pl.edu.pg.student.AUI.character.repository.api.BookRepository;
import pl.edu.pg.student.AUI.character.service.api.BookService;

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

    @Override
    public Optional<List<Book>> findAllByAuthor(UUID authorId){
        return authorRepository.findById(authorId).map(repository::findAllByAuthor);
    }
}
