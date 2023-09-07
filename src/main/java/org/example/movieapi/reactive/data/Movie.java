package org.example.movieapi.reactive.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

// lombok
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
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

    private Integer directorId;
//    private String directorName;
//    private LocalDate directorBirthdate;
    @Transient
    private Person director;

}
