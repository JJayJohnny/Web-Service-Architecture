package pl.edu.pg.student.AUI.author.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.edu.pg.student.AUI.book.entity.Book;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "authors")
public class Author implements Serializable {

    @Id
    private UUID id;
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Book> books;
}
