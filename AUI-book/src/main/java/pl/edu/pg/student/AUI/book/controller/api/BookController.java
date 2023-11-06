package pl.edu.pg.student.AUI.book.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.student.AUI.book.dto.GetBookResponse;
import pl.edu.pg.student.AUI.book.dto.GetBooksResponse;
import pl.edu.pg.student.AUI.book.dto.PutBookRequest;

import java.util.UUID;

public interface BookController {

    @GetMapping("/api/books")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBooksResponse getBooks();


    @GetMapping("/api/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBookResponse getBook(
            @PathVariable("id")
            UUID bookId
    );

    @GetMapping("/api/authors/{authorId}/books")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBooksResponse getAuthorBooks(
            @PathVariable("authorId")
            UUID authorId
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
