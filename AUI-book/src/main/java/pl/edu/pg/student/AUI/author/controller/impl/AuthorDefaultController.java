package pl.edu.pg.student.AUI.author.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.student.AUI.author.controller.api.AuthorController;
import pl.edu.pg.student.AUI.author.entity.Author;
import pl.edu.pg.student.AUI.author.service.api.AuthorService;

import java.util.UUID;

@RestController
@Log
public class AuthorDefaultController implements AuthorController {
    private final AuthorService service;

    @Autowired
    public AuthorDefaultController(AuthorService service){
        this.service = service;
    }

    @Override
    public void putAuthor(UUID id){
        service.create(Author.builder().id(id).build());
    }

    @Override
    public void deleteAuthor(UUID id){
        service.find(id).ifPresentOrElse(
                author -> service.delete(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }
        );
    }
}
