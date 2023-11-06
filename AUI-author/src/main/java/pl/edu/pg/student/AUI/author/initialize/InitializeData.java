package pl.edu.pg.student.AUI.author.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.author.entity.Author;
import pl.edu.pg.student.AUI.author.service.api.AuthorService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final AuthorService authorService;

    @Autowired
    public InitializeData(AuthorService authorService){
        this.authorService = authorService;
    }

    @Override
    public void afterPropertiesSet(){
        if(authorService.findAll().isEmpty()){
            Author sapkowski = Author.builder()
                    .id(UUID.fromString("3c4148e3-d1d7-4841-8b57-96d4b69d78e8"))
                    .name("Andrzej Sapkowski")
                    .age(75)
                    .build();
            Author mickiewicz = Author.builder()
                    .id(UUID.fromString("b26c7fb7-0422-45e4-8e8e-03dbc772f98c"))
                    .name("Adam Mickiewicz")
                    .age(225)
                    .build();

            authorService.create(sapkowski);
            authorService.create(mickiewicz);

        }
    }
}
