package pl.edu.pg.student.AUI.character.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.character.dto.GetBookResponse;
import pl.edu.pg.student.AUI.character.entity.Book;

import java.util.function.Function;

@Component
public class BookToResponseFunction implements Function<Book, GetBookResponse> {
    @Override
    public GetBookResponse apply(Book entity){
        return GetBookResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .pages(entity.getPages())
                .author(GetBookResponse.Author.builder()
                        .id(entity.getAuthor().getId())
                        .name(entity.getAuthor().getName()).build())
                .build();
    }
}
