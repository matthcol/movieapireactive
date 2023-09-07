package org.example.movieapi.reactive.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// lombok
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
// json
@JsonInclude(JsonInclude.Include.NON_ABSENT)
// R2DBC
@Table("movies")
public class Movie {
    @Id
    private Integer id;
    private String title;
    private short year;
    private Short duration;
    private String posterUri;
}
