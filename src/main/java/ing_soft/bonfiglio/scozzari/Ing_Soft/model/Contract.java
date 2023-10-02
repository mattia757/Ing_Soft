package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Art5;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String birthPlace;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false, length = 16)
    private String taxCode;

    private String iva;

    @Column(nullable = false)
    private String stateOfCitizenship;

    @Column(nullable = false)
    private String residence;

    @Column(nullable = false)
    private String domicile;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 27)
    private String iban;

    @Column(nullable = false, length = 7)
    private String idDocument;

    private Date expirationDateResidencePermit;

    @Column(nullable = false)
    private String season;

    @Column(nullable = false)
    private String opera;

    @Column(nullable = false)
    private Date startOpera;

    @Column(nullable = false)
    private String venue;

    @Column(nullable = false)
    private Date startRehearsal;

    @Column(nullable = false)
    private int dayExcept;

    @Column(nullable = false)
    private int totalDays;

    @Column(nullable = false)
    private String nameTheater;

    @Column(nullable = false)
    private String cityTheater;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal compensationNumber;

    @Column(nullable = false)
    private String compensationLetter;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Art5 art5;

    @Column(precision = 10, scale = 2)
    private BigDecimal perDiem;

    @Column(precision = 10, scale = 2)
    private BigDecimal accomodation;

    @Column(nullable = false)
    private boolean charged;

    @Column(nullable = false)
    private Date issueDate;

    @OneToOne
    private Document document;
}
