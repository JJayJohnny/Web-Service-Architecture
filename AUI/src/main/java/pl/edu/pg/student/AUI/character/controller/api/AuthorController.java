package pl.edu.pg.student.AUI.character.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.student.AUI.character.dto.GetAuthorResponse;
import pl.edu.pg.student.AUI.character.dto.GetAuthorsResponse;
import pl.edu.pg.student.AUI.character.dto.PutAuthorRequest;

import java.util.UUID;

public interface AuthorController {

    @GetMapping("/api/authors")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAuthorsResponse getAuthors();

    @GetMapping("/api/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAuthorResponse getAuthor(
            @PathVariable("id")
            UUID id
    );

    @PutMapping(path = "/api/authors/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putAuthor(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutAuthorRequest request
    );

    @DeleteMapping("/api/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthor(
            @PathVariable("id")
            UUID id
    );
}
