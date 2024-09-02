package be.brussel.school.service;

import be.brussel.school.model.Loan;
import be.brussel.school.model.User;

import java.util.List;

public interface LoanService {
    Loan borrowBook(Long bookId, User borrower);
    Loan extendLoan(Long loanId);
    void returnBook(Long loanId);
    List<Loan> getBorrowedBooks(User borrower);
}
