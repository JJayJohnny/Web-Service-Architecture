package pl.edu.pg.student.AUI.book.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.book.dto.GetBooksResponse;
import pl.edu.pg.student.AUI.book.entity.Book;

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
