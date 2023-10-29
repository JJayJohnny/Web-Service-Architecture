package pl.edu.pg.student.AUI.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.character.entity.Book;
import pl.edu.pg.student.AUI.character.service.api.AuthorService;
import pl.edu.pg.student.AUI.character.service.api.BookService;

import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public ApplicationCommand(BookService bookService, AuthorService authorService){
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String ... args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while(true){
            command = scanner.nextLine();
            switch (command){
                case "get_commands" -> {
                    System.out.println("get_commands\nget_books\nget_authors\nadd_book\ndelete_book\nquit");
                }
                case "get_books" -> {
                    System.out.println(bookService.findAll());
                }
                case "get_authors" -> {
                    System.out.println(authorService.findAll());
                }
                case "add_book" -> {
                    System.out.println("Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Pages: ");
                    String pages = scanner.nextLine();
                    System.out.println("Author ID: ");
                    String authorID = scanner.nextLine();
                    try {
                        Book book = Book.builder()
                                .id(UUID.randomUUID())
                                .title(title)
                                .pages(Integer.parseInt(pages))
                                .author(authorService.find(UUID.fromString(authorID)).orElseThrow(Exception::new))
                                .build();
                        bookService.create(book);
                    } catch (Exception ex){
                        System.out.println("Error adding book");
                    }
                }
                case "delete_book" -> {
                    System.out.println("ID: ");
                    String ID = scanner.nextLine();
                    try {
                        bookService.delete(UUID.fromString(ID));
                    } catch (Exception ex){
                        System.out.println("Error deleting book");
                    }
                }
                case "quit" -> {
                    break main_loop;
                }
            }
        }
    }
}
