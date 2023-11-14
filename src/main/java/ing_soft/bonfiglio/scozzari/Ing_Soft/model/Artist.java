package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    //ATTRIBUTES: DONE
    //FK:

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

    @ManyToMany(cascade = CascadeType.PERSIST)
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
    private Set<Agency> agencies = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    //@ManyToMany(mappedBy = "artists")
    //private Set<Opera> operas = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "opera_artist",
            inverseJoinColumns = @JoinColumn(name = "opera_id"),
            joinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Opera> operas = new HashSet<>();

    @OneToMany
    private Set<DigitalDrawer> digitalDrawers = new HashSet<>();

    @ManyToOne
    private Student student;

    @ManyToOne
    private PermanentWork permanentWork;

    @ManyToOne
    private Retired retired;

    @ManyToOne
    private Unemployed unemployed;

    @ManyToOne
    private TemporaryWork temporaryWork;

    //TODO Gestire bene le relazioni tra artista e tipo di lavoro (la facciamo one to one) - vedi db

    @OneToOne(mappedBy = "artist")
    private BankAccountIT bankAccountIT;

    @OneToOne(mappedBy = "artist")
    private BankAccountForeign bankAccountForeign;

    //TODO Gestire bene le relazioni tra artista e i tipi di conto bancario (la facciamo one to one) - vedi db

    @AssertTrue(message = "L'utente deve essere maggiorenne")
    private boolean isAdult(){
        return Period.between(getBirthDate() , LocalDate.now()).getYears() >= 18;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthState='" + birthState + '\'' +
                ", educationTitle='" + educationTitle + '\'' +
                ", isEuropean=" + isEuropean +
                ", stateOfCitizenship=" + stateOfCitizenship +
                ", cellPhone1='" + cellPhone1 + '\'' +
                ", cellPhone2='" + cellPhone2 + '\'' +
                ", pec='" + pec + '\'' +
                ", website='" + website + '\'' +
                ", residence='" + residence + '\'' +
                ", postalCodeOfResidence='" + postalCodeOfResidence + '\'' +
                ", cityOfResidence='" + cityOfResidence + '\'' +
                ", provinceOfResidence='" + provinceOfResidence + '\'' +
                ", regionOfResidence='" + regionOfResidence + '\'' +
                ", stateOfResidence='" + stateOfResidence + '\'' +
                ", domicile='" + domicile + '\'' +
                ", postalCodeOfDomicile='" + postalCodeOfDomicile + '\'' +
                ", cityOfDomicile='" + cityOfDomicile + '\'' +
                ", provinceOfDomicile='" + provinceOfDomicile + '\'' +
                ", regionOfDomicile='" + regionOfDomicile + '\'' +
                ", stateOfDomicile='" + stateOfDomicile + '\'' +
                ", stageName='" + stageName + '\'' +
                ", instrument='" + instrument + '\'' +
                ", voice='" + voice + '\'' +
                ", isIva=" + isIva +
                ", iva='" + iva + '\'' +
                ", taxation=" + taxation +
                ", inpsNumber='" + inpsNumber + '\'' +
                ", memberFrom=" + memberFrom +
                ", occupation=" + occupation +
                '}';
    }
}
