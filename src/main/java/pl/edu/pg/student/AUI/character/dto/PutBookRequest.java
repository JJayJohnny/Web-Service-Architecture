package pl.edu.pg.student.AUI.character.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutBookRequest {
    private String title;
    private Integer pages;
    private UUID author;
}
