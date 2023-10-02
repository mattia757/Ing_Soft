package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.MemberFrom;
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
public class Invoice {

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

    @Column(nullable = false, length = 6)
    private String cap;

    @Column(nullable = false, length = 255)
    private String city;

    @Column(nullable = false, length = 16)
    private String taxCode;

    @Column(nullable = false, length = 255)
    private String stateOfCitizenship;

    @Column(nullable = false, length = 255)
    private String residence;

    @Column(nullable = false, length = 27)
    private String iban;

    @Column(nullable = false, length = 255)
    private String theater;

    @Column(nullable = false, length = 255)
    private String cityTheater;

    @Column(nullable = false, length = 255)
    private String venueTheater;

    @Column(nullable = false, length = 6)
    private String capTheater;

    @Column(nullable = false, length = 11)
    private String ivaTheater;

    @Column(nullable = false, length = 11)
    private String taxCodeTheater;

    private String uniqueCode;

    private String recipientCode;

    @Column(nullable = false, length = 255)
    private String opera;

    @Column(nullable = false, length = 255)
    private String role;

    @Column(nullable = false)
    private Date startOpera;

    @Column(nullable = false)
    private int dayExcept;

    @Column(nullable = false)
    private int totalDays;

    @Column(nullable = false, length = 255)
    private String season;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberFrom memberFrom;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal compensationNumber;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal inpsRate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal taxable2;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal rate2;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal taxable3;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal rate3;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal rate4;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal rate5;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal net;

    @Column(nullable = false)
    private boolean stamp;

    @OneToOne
    private Document document;
}
