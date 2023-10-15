package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemporaryWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate deadline;

    @Column(nullable = false)
    private String employer;
    //TODO Specify agency

    @Column(nullable = false)
    private boolean isRevenueOver5000;

    @OneToMany
    private Set<Artist> artists = new HashSet<>();
}
