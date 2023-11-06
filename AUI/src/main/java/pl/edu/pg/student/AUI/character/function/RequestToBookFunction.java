package pl.edu.pg.student.AUI.character.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.character.dto.PutBookRequest;
import pl.edu.pg.student.AUI.character.entity.Author;
import pl.edu.pg.student.AUI.character.entity.Book;

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
