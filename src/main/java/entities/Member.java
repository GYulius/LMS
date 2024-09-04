package entities;

import enums.Social;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Builder
@Entity
@Table(name = "members")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Social social;

    private int age;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Loan> loans;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", social=" + social +
                ", age=" + age +
                '}';
    }
}
