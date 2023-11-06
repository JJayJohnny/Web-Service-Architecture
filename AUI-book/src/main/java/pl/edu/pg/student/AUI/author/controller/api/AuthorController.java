package pl.edu.pg.student.AUI.author.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public interface AuthorController {

    @DeleteMapping("/api/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthor(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/authors/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putAuthor(
            @PathVariable("id")
            UUID id
    );
}
