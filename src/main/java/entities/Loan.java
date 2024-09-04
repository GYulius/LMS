package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Builder
@Entity
@Table(name = "loans")
@Getter
@Setter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate loanDate;

    private LocalDate returnDate;

    private boolean isReturned = false;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", book=" + book +
                ", member=" + member +
                '}';
    }
}
