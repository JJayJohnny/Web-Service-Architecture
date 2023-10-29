package pl.edu.pg.student.AUI.character.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.character.dto.GetBooksResponse;
import pl.edu.pg.student.AUI.character.entity.Book;

import java.util.List;
import java.util.function.Function;

@Component
public class BooksToResponseFunction implements Function<List<Book>, GetBooksResponse> {
    @Override
    public GetBooksResponse apply(List<Book> entities){
        return GetBooksResponse.builder()
                .books(entities.stream()
                        .map(book -> GetBooksResponse.Book.builder()
                                .id(book.getId())
                                .title(book.getTitle())
                                .build())
                        .toList())
                .build();
    }
}
