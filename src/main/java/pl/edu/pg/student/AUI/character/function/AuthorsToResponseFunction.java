package pl.edu.pg.student.AUI.character.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.character.dto.GetAuthorsResponse;
import pl.edu.pg.student.AUI.character.entity.Author;

import java.util.List;
import java.util.function.Function;

@Component
public class AuthorsToResponseFunction implements Function<List<Author>, GetAuthorsResponse> {
    @Override
    public GetAuthorsResponse apply(List<Author> entities){
        return GetAuthorsResponse.builder()
                .authors(entities.stream()
                        .map(author -> GetAuthorsResponse.Author.builder()
                                .id(author.getId())
                                .name(author.getName())
                                .build())
                        .toList())
                .build();
    }
}
