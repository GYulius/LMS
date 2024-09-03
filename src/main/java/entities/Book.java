package entities;

import enums.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table(name = "books")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String author;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String description;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Loan> loans;



}
