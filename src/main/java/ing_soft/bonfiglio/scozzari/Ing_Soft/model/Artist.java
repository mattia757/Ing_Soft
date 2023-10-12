package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String birthPlace;

    @Column(nullable = false)
    private String birthState;

    @Column(nullable = false)
    private String educationTitle;

    @Column(nullable = false)
    private Boolean isEuropean;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StateOfCitizenship stateOfCitizenship;

    @Column(nullable = false, unique = true)
    private String cellPhone1;

    @Column(nullable = true, unique = true)
    private String cellPhone2;

    @Column(nullable = true, unique = true)
    private String pec;

    @Column(nullable = true)
    private String website;

    @Column(nullable = false)
    private String residence;

    @Column(nullable = false)
    private String postalCodeOfResidence;

    @Column(nullable = false)
    private String cityOfResidence;

    @Column(nullable = false)
    private String provinceOfResidence;

    @Column(nullable = false)
    private String regionOfResidence;

    @Column(nullable = false)
    private String stateOfResidence;

    @Column(nullable = false)
    private String domicile;

    @Column(nullable = false)
    private String postalCodeOfDomicile;

    @Column(nullable = false)
    private String cityOfDomicile;

    @Column(nullable = false)
    private String provinceOfDomicile;

    @Column(nullable = false)
    private String regionOfDomicile;

    @Column(nullable = false)
    private String stateOfDomicile;

    @Column(nullable = true)
    private String stageName;

    @Column(nullable = true)
    private String instrument;

    @Column(nullable = true)
    private String voice;

    @Column(nullable = true)
    private Boolean isIva;

    @Column(nullable = true, unique = true)
    private String iva;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Taxation taxation;

    @Column(nullable = true)
    private String inpsNumber;

    @Column(nullable = false)
    private Boolean memberFrom;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    @ManyToMany
    @JoinTable(
            name = "artist_typology",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "typology_id"))
    private Set<Typology> typologies = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "artist_agency",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "agency_id"))
    private List<Agency> agencies = new ArrayList<>();

    @OneToOne
    private User user;

    @OneToMany
    private Set<DigitalDrawer> digitalDrawers = new HashSet<>();

    @OneToOne(mappedBy = "artist")
    private Student student;

    @OneToOne(mappedBy = "artist")
    private PermanentWork permanentWork;

    @OneToOne(mappedBy = "artist")
    private Retired retired;

    @OneToOne(mappedBy = "artist")
    private Unemployed unemployed;

    @OneToOne(mappedBy = "artist")
    private TemporaryWork temporaryWork;

    @OneToOne(mappedBy = "artist")
    private BankAccountIT bankAccountIT;

    @OneToOne(mappedBy = "artist")
    private BankAccountForeign bankAccountForeign;

    @AssertTrue(message = "L'utente deve essere maggiorenne")
    private boolean isAdult(){
        return Period.between(getBirthDate() , LocalDate.now()).getYears() >= 18;
    }

}
