package entities;

import enums.Genre;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table(name = "books")
@Getter
@Setter
// @Data
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

    private boolean isLoaned = false;


    // @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Loan> loans;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                '}';
    }
}
