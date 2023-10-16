package ing_soft.bonfiglio.scozzari.Ing_Soft.model.middleTables;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.TheaterRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTheater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Theater theater;

    @Column(nullable = false)
    private TheaterRoles role;

}
