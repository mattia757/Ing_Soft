package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Opera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate startRehearsal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seasonId", nullable = false)
    private Season season;

    @OneToOne(fetch = FetchType.LAZY)
    private VenueTheater venue;

    @OneToMany(mappedBy = "opera", fetch = FetchType.LAZY)
    private Set<Play> play = new HashSet<>();

    /*@ManyToMany
    @JoinTable(
        name = "opera_artist",
        joinColumns = @JoinColumn(name = "opera_id"),
        inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artist> artists = new HashSet<>();*/

    @ManyToMany(mappedBy = "operas")
    private Set<Artist> artists = new HashSet<>();
}