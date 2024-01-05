package pl.edu.pg.student.AUI.author.event.repository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.student.AUI.author.event.repository.api.AuthorEventRepository;

import java.util.UUID;

@Repository
public class AuthorEventRestRepository implements AuthorEventRepository {
    private final RestTemplate restTemplate;

    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public AuthorEventRestRepository(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient){
        this.restTemplate = restTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }

    @Override
    public void add(UUID id){
        String uri = loadBalancerClient.choose("aui-book").getUri().toString();
        restTemplate.put(uri + "/api/authors/{id}", null, id);
    }

    @Override
    public void delete(UUID id){
        String uri = loadBalancerClient.choose("aui-book").getUri().toString();
        restTemplate.delete(uri + "/api/authors/{id}", id);
    }
}
