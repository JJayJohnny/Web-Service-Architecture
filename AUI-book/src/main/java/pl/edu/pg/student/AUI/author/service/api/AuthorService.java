package pl.edu.pg.student.AUI.author.service.api;

import pl.edu.pg.student.AUI.author.entity.Author;

import java.util.Optional;
import java.util.UUID;

public interface AuthorService {
    Optional<Author> find(UUID id);

    void create(Author author);

    void delete(UUID id);
}
