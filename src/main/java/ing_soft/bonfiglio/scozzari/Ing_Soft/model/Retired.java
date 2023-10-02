package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Age;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Retired {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Age age;

    @OneToOne
    private Artist artist;

}
