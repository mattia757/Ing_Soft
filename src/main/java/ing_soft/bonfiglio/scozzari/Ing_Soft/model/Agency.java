package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.middleTables.UserAgency;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Agency")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false , unique = true)
    @Email(message = "The email must respect the format")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String email;

    @Column(nullable = false , unique = true)
    @Email(message = "The pec must respect the format")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String pec;

    @Column(nullable = false, unique = true)
    //@Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$\n")
    private String tel1;

    @Column(nullable = true, unique = true)
    //@Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$\n")
    private String tel2;

    @Column(nullable = true)
    private String webSite;

    @ManyToMany(mappedBy = "agencies", cascade = {CascadeType.ALL})
    private List<Artist> artists = new ArrayList<>();

    @OneToMany(mappedBy = "agency")
    private List<UserAgency> userAgencies = new ArrayList<>();

}