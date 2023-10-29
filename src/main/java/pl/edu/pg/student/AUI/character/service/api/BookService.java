package pl.edu.pg.student.AUI.character.service.api;

import pl.edu.pg.student.AUI.character.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    Optional<Book> find(UUID id);

    List<Book> findAll();

    void create(Book book);

    void update(Book book);

    void delete(UUID id);

    Optional<List<Book>> findAllByAuthor(UUID authorId);
}
