package be.brussel.school.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id", nullable = false)
    private User borrower; // Can be a Manager, Teacher, or Student

    private LocalDate borrowDate;
    private LocalDate dueDate;

    private boolean returned;
    private int extensionCount = 0;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    private boolean extended = false;

    public enum LoanStatus {
        ACTIVE,
        EXTENDED,
        RESERVED,
        EXPIRED
    }
}
