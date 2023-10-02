package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Residence_Permit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String documentNumber;

    @Column(nullable = false, length = 100)
    private String issuingAuthority;

    @Column(nullable = false)
    private Date expirationDate;

    @Column(nullable = false, length = 100)
    private String permitHolderName;

    @Column(nullable = false, length = 100)
    private String permitHolderSurname;

    @Column(nullable = false, length = 50)
    private String nationality;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false, length = 100)
    private String birthPlace;

    @Column(nullable = false, length = 255)
    private String residenceAddress;

    @Column(nullable = false, length = 100)
    private String permitCategory;

    @Column(nullable = false)
    private Date permitStartDate;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String additionalInfo;

    @OneToOne
    private Document document;
}
