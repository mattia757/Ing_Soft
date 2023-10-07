package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Typology {

    @Id
    @Column(length = 3)
    private String id;

    @Column(nullable = false)
    private String nameTypology;

    @ManyToMany(mappedBy = "typologies")
    private Set<Artist> artists = new HashSet<>();
}