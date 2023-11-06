package pl.edu.pg.student.AUI.character.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.student.AUI.character.dto.GetBookResponse;
import pl.edu.pg.student.AUI.character.dto.GetBooksResponse;
import pl.edu.pg.student.AUI.character.dto.PutBookRequest;

import java.util.UUID;

public interface BookController {

    @GetMapping("/api/books")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBooksResponse getBooks();

    @GetMapping("/api/authors/{authorId}/books")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBooksResponse getAuthorBooks(
            @PathVariable("authorId")
            UUID authorId
    );

    @GetMapping("/api/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBookResponse getBook(
            @PathVariable("id")
            UUID bookId
    );

    @PutMapping(path = "/api/books/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putBook(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutBookRequest request
    );

    @DeleteMapping("/api/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBook(
            @PathVariable("id")
            UUID id
    );
}
