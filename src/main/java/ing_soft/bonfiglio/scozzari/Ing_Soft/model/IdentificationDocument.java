package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.DocumentType;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentType documentType;

    @Column(nullable = false, length = 20)
    private String documentNumber;

    @Column(nullable = false, length = 100)
    private String issuingAuthority;

    @Column(nullable = false)
    private Date expirationDate;

    @Column(nullable = false)
    private Date releaseDate;

    @OneToOne
    private Document document;

}
