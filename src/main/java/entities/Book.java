package entities;

import enums.Genre;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String author;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String description;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Loan> loans;



}
