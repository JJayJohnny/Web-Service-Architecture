package pl.edu.pg.student.AUI.author.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.student.AUI.author.entity.Author;
import pl.edu.pg.student.AUI.author.event.repository.api.AuthorEventRepository;
import pl.edu.pg.student.AUI.author.repository.api.AuthorRepository;
import pl.edu.pg.student.AUI.author.service.api.AuthorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorDefaultService implements AuthorService {
    private final AuthorRepository repository;

    private final AuthorEventRepository eventRepository;

    @Autowired
    public AuthorDefaultService(AuthorRepository repository, AuthorEventRepository eventRepository){
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public Optional<Author> find(UUID id){
        return repository.findById(id);
    }

    @Override
    public List<Author> findAll(){
        return repository.findAll();
    }

    @Override
    public void create(Author author){
        repository.save(author);
//        repository.add(author.getId());
    }

    @Override
    public void update(Author author){
        repository.save(author);
    }

    @Override
    public void delete(UUID id){
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }
}
