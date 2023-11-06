package pl.edu.pg.student.AUI.author.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.author.dto.GetAuthorResponse;
import pl.edu.pg.student.AUI.author.entity.Author;

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
