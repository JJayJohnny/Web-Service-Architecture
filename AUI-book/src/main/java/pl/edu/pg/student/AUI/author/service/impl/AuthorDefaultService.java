package pl.edu.pg.student.AUI.author.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.student.AUI.author.entity.Author;
import pl.edu.pg.student.AUI.author.repository.api.AuthorRepository;
import pl.edu.pg.student.AUI.author.service.api.AuthorService;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorDefaultService implements AuthorService {
    private final AuthorRepository repository;

    @Autowired
    public AuthorDefaultService(AuthorRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<Author> find(UUID id){
        return repository.findById(id);
    }

    @Override
    public void create(Author author){
        repository.save(author);
    }

    @Override
    public void delete(UUID id){
        repository.findById(id).ifPresent(repository::delete);
    }
}
