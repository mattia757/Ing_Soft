package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Theater")
public class Theater extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    //@Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$\n")
    private String tel;

    @Column(nullable = false , unique = true)
    @Email(message = "The email must respect the format")
    //@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String email;

    @Column(nullable = false, unique = true)
    @Email(message = "The email must respect the format")
    //@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String pec;

    @Column(nullable = false, unique = true)
    //@Pattern(regexp = "/^(?:[A-Z][AEIOU][AEIOUX]|[AEIOU]X{2}|[B-DF-HJ-NP-TV-Z]{2}[A-Z]){2}(?:[\\dLMNP-V]{2}(?:[A-EHLMPR-T](?:[04LQ][1-9MNP-V]|[15MR][\\dLMNP-V]|[26NS][0-8LMNP-U])|[DHPS][37PT][0L]|[ACELMRT][37PT][01LM]|[AC-EHLMPR-T][26NS][9V])|(?:[02468LNQSU][048LQU]|[13579MPRTV][26NS])B[26NS][9V])(?:[A-MZ][1-9MNP-V][\\dLMNP-V]{2}|[A-M][0L](?:[1-9MNP-V][\\dLMNP-V]|[0L][1-9MNP-V]))[A-Z]$/i")
    private String taxCode;

    @Column(nullable = true)
    private String webSite;

    @Column(nullable = false, unique = true)
    //@Pattern(regexp = "/^[a-zA-Z0-9]*$/")
    private String iva;

    @Column(nullable = true, unique = true)
    private String uniqueCode;

    @Column(nullable = true, unique = true)
    private String recipientCode;

    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
    private List<Season> seasons;

    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
    private Set<VenueTheater> venues = new HashSet<>();

    @OneToMany(mappedBy = "theater")
    private Set<DigitalDrawer> digitalDrawers = new HashSet<>();
}
