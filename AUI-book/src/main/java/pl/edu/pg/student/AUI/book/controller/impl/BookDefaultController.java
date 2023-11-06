package pl.edu.pg.student.AUI.book.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.student.AUI.author.service.api.AuthorService;
import pl.edu.pg.student.AUI.book.controller.api.BookController;
import pl.edu.pg.student.AUI.book.dto.GetBookResponse;
import pl.edu.pg.student.AUI.book.dto.GetBooksResponse;
import pl.edu.pg.student.AUI.book.dto.PutBookRequest;
import pl.edu.pg.student.AUI.book.function.BookToResponseFunction;
import pl.edu.pg.student.AUI.book.function.BooksToResponseFunction;
import pl.edu.pg.student.AUI.book.function.RequestToBookFunction;
import pl.edu.pg.student.AUI.book.service.api.BookService;

import java.util.UUID;

@RestController
@Log
public class BookDefaultController implements BookController {
    private final BookService service;

    private final AuthorService authorService;

    private final BookToResponseFunction bookToResponse;

    private final BooksToResponseFunction booksToResponse;

    private final RequestToBookFunction requestToBook;

    @Autowired
    public BookDefaultController(
            BookService service,
            AuthorService authorService,
            BookToResponseFunction bookToResponse,
            BooksToResponseFunction booksToResponse,
            RequestToBookFunction requestToBook
    ){
        this.service = service;
        this.authorService = authorService;
        this.booksToResponse = booksToResponse;
        this.bookToResponse = bookToResponse;
        this.requestToBook = requestToBook;
    }

    @Override
    public GetBooksResponse getBooks(){
        return booksToResponse.apply(service.findAll());
    }

    @Override
    public GetBookResponse getBook(UUID id){
        return service.find(id)
                .map(bookToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetBooksResponse getAuthorBooks(UUID authorId){
        return service.findAllByAuthor(authorId)
                .map(booksToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putBook(UUID id, PutBookRequest request){
        authorService.find(request.getAuthor()).ifPresentOrElse(
                author -> service.create(requestToBook.apply(id, request)),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

    @Override
    public void deleteBook(UUID id){
        service.find(id)
                .ifPresentOrElse(
                        book -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
