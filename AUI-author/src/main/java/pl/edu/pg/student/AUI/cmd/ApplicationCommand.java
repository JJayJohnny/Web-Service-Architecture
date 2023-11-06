package pl.edu.pg.student.AUI.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.pg.student.AUI.author.service.api.AuthorService;

import java.util.Scanner;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final AuthorService authorService;

    @Autowired
    public ApplicationCommand(AuthorService authorService){
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
                case "get_authors" -> {
                    System.out.println(authorService.findAll());
                }
                case "quit" -> {
                    break main_loop;
                }
            }
        }
    }
}
