package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Revenue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unemployed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String employer;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // Specifica il tipo di enum (STRING)
    private Revenue revenue;

    @OneToOne
    private Artist artist;
}
