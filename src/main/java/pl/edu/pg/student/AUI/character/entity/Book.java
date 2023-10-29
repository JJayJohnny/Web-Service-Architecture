package pl.edu.pg.student.AUI.character.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Id
    private UUID id;

    String title;
    Integer pages;

    @ManyToOne
    @JoinColumn(name = "author")
    Author author;
}
