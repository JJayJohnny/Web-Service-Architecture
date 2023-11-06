package pl.edu.pg.student.AUI.author.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchAuthorRequest {
    private String name;
    private Integer age;
}
