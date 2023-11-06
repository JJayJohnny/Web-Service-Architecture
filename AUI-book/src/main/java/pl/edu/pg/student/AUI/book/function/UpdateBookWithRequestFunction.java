package pl.edu.pg.student.AUI.book.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.book.dto.PatchBookRequest;
import pl.edu.pg.student.AUI.book.entity.Book;

import java.util.function.BiFunction;

@Component
public class UpdateBookWithRequestFunction implements BiFunction<Book, PatchBookRequest, Book> {
    @Override
    public Book apply(Book entity, PatchBookRequest request){
        return Book.builder()
                .id(entity.getId())
                .title(request.getTitle())
                .pages(request.getPages())
                .build();
    }
}
