package pl.edu.pg.student.AUI.character.entity;

import lombok.*;

@EqualsAndHashCode
@Builder
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class BookDTO {
    String title;

    Integer pages;

    String author;
}
