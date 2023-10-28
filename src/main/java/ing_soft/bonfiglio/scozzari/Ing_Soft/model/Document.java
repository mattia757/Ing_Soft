package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column
    private Blob media;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private Boolean approved;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToMany(mappedBy = "documents")
    private Set<DigitalDrawer> digitalDrawers = new HashSet<>();

    @OneToOne(mappedBy = "document")
    private IdentificationDocument identificationDocument;

    @OneToOne(mappedBy = "document")
    private Contract contract;

    @OneToOne(mappedBy = "document")
    private Receipt receipt;

    @OneToOne(mappedBy = "document")
    private Invoice invoice;

    @OneToOne(mappedBy = "document")
    private Residence_Permit residence_permit;
}