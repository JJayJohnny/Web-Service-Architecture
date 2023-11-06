package pl.edu.pg.student.AUI.author.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.student.AUI.author.controller.api.AuthorController;
import pl.edu.pg.student.AUI.author.dto.GetAuthorResponse;
import pl.edu.pg.student.AUI.author.dto.GetAuthorsResponse;
import pl.edu.pg.student.AUI.author.dto.PutAuthorRequest;
import pl.edu.pg.student.AUI.author.function.*;
import pl.edu.pg.student.AUI.author.service.api.AuthorService;

import java.util.UUID;

@RestController
@Log
public class AuthorDefaultController implements AuthorController {
    private final AuthorService service;

    private final AuthorToResponseFunction authorToResponse;

    private final AuthorsToResponseFunction authorsToResponse;

    private final RequestToAuthorFunction requestToAuthor;

    @Autowired
    public AuthorDefaultController(
            AuthorService service,
            AuthorToResponseFunction authorToResponse,
            AuthorsToResponseFunction authorsToResponse,
            RequestToAuthorFunction requestToAuthor
    ){
        this.service = service;
        this.authorsToResponse = authorsToResponse;
        this.authorToResponse = authorToResponse;
        this.requestToAuthor = requestToAuthor;
    }

    @Override
    public GetAuthorsResponse getAuthors(){
        return authorsToResponse.apply(service.findAll());
    }

    @Override
    public GetAuthorResponse getAuthor(UUID id){
        return service.find(id)
                .map(authorToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putAuthor(UUID id, PutAuthorRequest request){
        service.create(requestToAuthor.apply(id, request));
    }

    @Override
    public void deleteAuthor(UUID id){
        service.find(id)
                .ifPresentOrElse(
                        author -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
