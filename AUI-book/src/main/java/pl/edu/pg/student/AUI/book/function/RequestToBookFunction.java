package pl.edu.pg.student.AUI.book.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.author.entity.Author;
import pl.edu.pg.student.AUI.book.dto.PutBookRequest;
import pl.edu.pg.student.AUI.book.entity.Book;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToBookFunction implements BiFunction<UUID, PutBookRequest, Book> {
    @Override
    public Book apply(UUID id, PutBookRequest request){
        return Book.builder()
                .id(id)
                .title(request.getTitle())
                .pages(request.getPages())
                .author(Author.builder()
                        .id(request.getAuthor())
                        .build())
                .build();
    }
}
