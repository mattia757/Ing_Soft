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

    @ManyToOne(fetch = FetchType.LAZY)
    private Theater theater;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "season")
    private List<Opera> operas = new ArrayList<>();

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", artisticDirectorSocialCosts=" + artisticDirectorSocialCosts +
                ", artisticDirectorCompensation=" + artisticDirectorCompensation +
                ", artisticPersonnelGrossSalary=" + artisticPersonnelGrossSalary +
                ", artisticPersonnelSocialCosts=" + artisticPersonnelSocialCosts +
                ", technicalPersonnelGrossSalary=" + technicalPersonnelGrossSalary +
                ", technicalPersonnelSocialCosts=" + technicalPersonnelSocialCosts +
                ", administrativePersonnelGrossSalary=" + administrativePersonnelGrossSalary +
                ", administrativePersonnelSocialCosts=" + administrativePersonnelSocialCosts +
                ", artisticPersonnelPerDiem=" + artisticPersonnelPerDiem +
                ", technicalPersonnelPerDiem=" + technicalPersonnelPerDiem +
                ", projectRelatedDailyExpenses=" + projectRelatedDailyExpenses +
                ", travelTransportAccommodationCosts=" + travelTransportAccommodationCosts +
                '}';
    }
}