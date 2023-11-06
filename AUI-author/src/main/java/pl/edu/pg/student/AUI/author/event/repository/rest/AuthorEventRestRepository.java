package pl.edu.pg.student.AUI.author.event.repository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.student.AUI.author.event.repository.api.AuthorEventRepository;

import java.util.UUID;

@Repository
public class AuthorEventRestRepository implements AuthorEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public AuthorEventRestRepository(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public void add(UUID id){
        restTemplate.put("/api/authors/{id}", null, id);
    }

    @Override
    public void delete(UUID id){
        restTemplate.delete("/api/authors/{id}", id);
    }
}
