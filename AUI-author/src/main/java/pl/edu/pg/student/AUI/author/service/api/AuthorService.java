package pl.edu.pg.student.AUI.author.service.api;

import pl.edu.pg.student.AUI.author.entity.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorService {
    Optional<Author> find(UUID id);

    List<Author> findAll();

    void create(Author author);

    void update(Author author);

    void delete(UUID id);
}
