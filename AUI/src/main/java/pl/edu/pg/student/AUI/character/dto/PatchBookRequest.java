package pl.edu.pg.student.AUI.character.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchBookRequest {
    private String title;
    private Integer pages;
}
