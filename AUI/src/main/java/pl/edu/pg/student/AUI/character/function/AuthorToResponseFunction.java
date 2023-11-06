package pl.edu.pg.student.AUI.character.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.character.dto.GetAuthorResponse;
import pl.edu.pg.student.AUI.character.entity.Author;

import java.util.function.Function;

@Component
public class AuthorToResponseFunction implements Function<Author, GetAuthorResponse> {
    @Override
    public GetAuthorResponse apply(Author entity){
        return GetAuthorResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .build();
    }
}
