package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Revenue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date deadline;

    @Column(nullable = false)
    private String employer;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Revenue revenue;

    @OneToOne
    private Artist artist;
}
