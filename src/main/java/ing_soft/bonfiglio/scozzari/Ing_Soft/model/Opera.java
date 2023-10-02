package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date startDate;

    @Column
    private Long idVenue;

    @Column(nullable = false)
    private Date startRehearsal;

    @ManyToOne
    @JoinColumn(name = "seasonId", nullable = false)
    private Season season;

    @OneToOne
    private VenueTheater venue;

    @OneToMany(mappedBy = "opera")
    private Set<Play> play = new HashSet<>();
}