package pl.edu.pg.student.AUI.character.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutAuthorRequest {
    private String name;
    private Integer age;
}
