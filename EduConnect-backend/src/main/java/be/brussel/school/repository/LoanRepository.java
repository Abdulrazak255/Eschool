package be.brussel.school.repository;

import be.brussel.school.model.Loan;
import be.brussel.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByBorrowerId(Long borrowerId);

    List<Loan> findByBookId(Long bookId);

    List<Loan> findByStatus(Loan.LoanStatus status);

    List<Loan> findByDueDateBefore(LocalDate date);

    List<Loan> findByReturned(boolean returned);

    List<Loan> findByBorrowerAndReturnedFalse(User borrower);
}
