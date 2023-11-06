package pl.edu.pg.student.AUI.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.character.entity.Author;
import pl.edu.pg.student.AUI.character.entity.Book;
import pl.edu.pg.student.AUI.character.service.api.AuthorService;
import pl.edu.pg.student.AUI.character.service.api.BookService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public InitializeData(BookService bookService, AuthorService authorService){
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void afterPropertiesSet() throws Exception{

        Author sapkowski = Author.builder()
                .id(UUID.fromString("3c4148e3-d1d7-4841-8b57-96d4b69d78e8"))
                .name("Andrzej Sapkowski")
                .age(75)
                .build();
        Author mickiewicz = Author.builder()
                .id(UUID.fromString("b26c7fb7-0422-45e4-8e8e-03dbc772f98c"))
                .name("Adam Mickiewicz")
                .age(225)
                .build();

        authorService.create(sapkowski);
        authorService.create(mickiewicz);

        Book krewElfow = Book.builder()
                .id(UUID.fromString("16699753-4300-4482-9959-2e5ab53788c2"))
                .title("Krew Elfow")
                .pages(340)
                .author(sapkowski)
                .build();
        Book czasPogardy = Book.builder()
                .id(UUID.fromString("f68937d9-8a5c-42d9-a8d9-3ec91513b3e8"))
                .title("Czas pogardy")
                .pages(368)
                .author(sapkowski)
                .build();

        Book panTadeusz = Book.builder()
                .id(UUID.fromString("cf845f7c-cb30-48ae-a538-b07e161987ed"))
                .title("Pan Tadeusz")
                .pages(376)
                .author(mickiewicz)
                .build();
        Book dziadyIII = Book.builder()
                .id(UUID.fromString("961dc24b-5bac-4ecf-aa53-986c3f57f9d7"))
                .title("Dziady III")
                .pages(153)
                .author(mickiewicz)
                .build();
        bookService.create(krewElfow);
        bookService.create(czasPogardy);
        bookService.create(panTadeusz);
        bookService.create(dziadyIII);
    }
}
