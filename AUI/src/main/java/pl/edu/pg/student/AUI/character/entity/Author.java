package pl.edu.pg.student.AUI.character.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "authors")
public class Author implements Serializable {

    @Id
    private UUID id;
    String name;
    Integer age;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Book> books;
}
