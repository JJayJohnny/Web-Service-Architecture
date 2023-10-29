package pl.edu.pg.student.AUI.character.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.student.AUI.character.entity.Author;
import pl.edu.pg.student.AUI.character.entity.Book;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findAllByAuthor(Author author);
}
