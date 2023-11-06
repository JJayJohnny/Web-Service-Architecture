package pl.edu.pg.student.AUI.character.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.character.dto.PatchBookRequest;
import pl.edu.pg.student.AUI.character.entity.Book;

import java.util.function.BiFunction;

@Component
public class UpdateBookWithRequestFunction implements BiFunction<Book, PatchBookRequest, Book> {
    @Override
    public Book apply(Book entity, PatchBookRequest request){
        return Book.builder()
                .id(entity.getId())
                .title(request.getTitle())
                .pages(request.getPages())
                .author(entity.getAuthor())
                .build();
    }
}
