package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueTheater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String venue;

    @Column(nullable = false, length = 6)
    private String cap;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Long capacity;

    @ManyToOne
    @JoinColumn(name = "idTheater") // Nome della colonna nella tabella Venue_Theatre che collega alla tabella Theater
    private Theater theater;

    @OneToOne(mappedBy = "venue")
    private Opera opera;
}
