package be.brussel.school.service;

import be.brussel.school.model.Book;
import be.brussel.school.model.Loan;
import be.brussel.school.model.User;
import be.brussel.school.repository.BookRepository;
import be.brussel.school.repository.LoanRepository;
import be.brussel.school.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    @Override
    public Loan borrowBook(Long bookId, User borrower) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("No copies available");
        }

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setBorrower(borrower);
        loan.setBorrowDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(30));
        loan.setStatus(Loan.LoanStatus.ACTIVE);

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        return loanRepository.save(loan);
    }

    @Override
    public Loan extendLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loan.getExtensionCount() >= 2) {
            throw new RuntimeException("Maximum extensions reached");
        }

        loan.setDueDate(loan.getDueDate().plusDays(30));
        loan.setExtensionCount(loan.getExtensionCount() + 1);
        loan.setStatus(Loan.LoanStatus.EXTENDED);

        return loanRepository.save(loan);
    }

    @Override
    public void returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.setReturned(true);
        loan.getBook().setAvailableCopies(loan.getBook().getAvailableCopies() + 1);

        bookRepository.save(loan.getBook());
        loanRepository.save(loan);
    }

    @Override
    public List<Loan> getBorrowedBooks(User borrower) {
        return loanRepository.findByBorrowerAndReturnedFalse(borrower);
    }
}
