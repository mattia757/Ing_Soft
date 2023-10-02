package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountIT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String beneficiaryName;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false, length = 5)
    private String abi;

    @Column(nullable = false, length = 5)
    private String cab;

    @Column(nullable = false, length = 27)
    private String iban;

    @OneToOne
    private Artist artist;
}
