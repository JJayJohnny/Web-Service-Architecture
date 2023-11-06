package pl.edu.pg.student.AUI.character.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.character.dto.PatchAuthorRequest;
import pl.edu.pg.student.AUI.character.entity.Author;

import java.util.function.BiFunction;

@Component
public class UpdateAuthorWithRequestFunction implements BiFunction<Author, PatchAuthorRequest, Author> {
    @Override
    public Author apply(Author entity, PatchAuthorRequest request){
        return Author.builder()
                .id(entity.getId())
                .name(request.getName())
                .age(request.getAge())
                .books(entity.getBooks())
                .build();
    }
}
