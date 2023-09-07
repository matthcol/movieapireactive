package org.example.movieapi.reactive.data;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@ToString
// R2DBC
@Table("persons")
public class Person {
    @Id
    private Integer id;

    private String name;

    private LocalDate birthdate;
}
