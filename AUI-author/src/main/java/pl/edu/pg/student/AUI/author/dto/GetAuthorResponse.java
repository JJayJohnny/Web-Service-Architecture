package pl.edu.pg.student.AUI.author.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetAuthorResponse {

    private UUID id;
    private String name;
    private Integer age;

}
