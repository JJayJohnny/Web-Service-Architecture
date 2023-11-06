package pl.edu.pg.student.AUI.author.entity;

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
}
