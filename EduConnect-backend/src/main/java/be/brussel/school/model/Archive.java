package be.brussel.school.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "archives")
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title; // Title of the archived document
    private String description; // Description of the archived document

    @Lob
    @Column(name = "document", columnDefinition = "BLOB")
    private byte[] document; // The archived document stored as a BLOB

    private Date archivedDate; // The date when the document was archived

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "archived_by", nullable = false)
    private User archivedBy; // The user who archived the document
}
