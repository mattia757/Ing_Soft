package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private BigDecimal artisticDirectorSocialCosts;

    @Column(nullable = false)
    private BigDecimal artisticDirectorCompensation;

    @Column(nullable = false)
    private BigDecimal artisticPersonnelGrossSalary;

    @Column(nullable = false)
    private BigDecimal artisticPersonnelSocialCosts;

    @Column(nullable = false)
    private BigDecimal technicalPersonnelGrossSalary;

    @Column(nullable = false)
    private BigDecimal technicalPersonnelSocialCosts;

    @Column(nullable = false)
    private BigDecimal administrativePersonnelGrossSalary;

    @Column(nullable = false)
    private BigDecimal administrativePersonnelSocialCosts;

    @Column(nullable = false)
    private BigDecimal artisticPersonnelPerDiem;

    @Column(nullable = false)
    private BigDecimal technicalPersonnelPerDiem;

    @Column(nullable = false)
    private BigDecimal projectRelatedDailyExpenses;

    @Column(nullable = false)
    private BigDecimal travelTransportAccommodationCosts;

    @ManyToMany(mappedBy = "seasons")
    @Column(nullable = false)
    private Set<Theater> theaters = new HashSet<>();

    @OneToMany(mappedBy = "season")
    private List<Opera> operas = new ArrayList<>();
}