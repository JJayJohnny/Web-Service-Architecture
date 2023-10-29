package pl.edu.pg.student.AUI.character.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.character.dto.PutAuthorRequest;
import pl.edu.pg.student.AUI.character.entity.Author;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToAuthorFunction implements BiFunction<UUID, PutAuthorRequest, Author> {
    @Override
    public Author apply(UUID id, PutAuthorRequest request){
        return Author.builder()
                .id(id)
                .name(request.getName())
                .age(request.getAge())
                .build();
    }
}
