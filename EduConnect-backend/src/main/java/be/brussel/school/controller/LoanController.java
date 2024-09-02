package be.brussel.school.controller;

import be.brussel.school.model.Loan;
import be.brussel.school.model.User;
import be.brussel.school.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/borrow")
    public ResponseEntity<Loan> borrowBook(@RequestParam Long bookId, @RequestBody User borrower) {
        return ResponseEntity.ok(loanService.borrowBook(bookId, borrower));
    }

    @PutMapping("/{loanId}/extend")
    public ResponseEntity<Loan> extendLoan(@PathVariable Long loanId) {
        return ResponseEntity.ok(loanService.extendLoan(loanId));
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<Void> returnBook(@PathVariable Long loanId) {
        loanService.returnBook(loanId);
        return ResponseEntity.noContent().build();
    }

  /*  @GetMapping("/borrower/{borrowerId}")
    public ResponseEntity<List<Loan>> getBorrowedBooks(@PathVariable Long borrowerId) {
        // Assuming `borrowerId` is the ID of the `User` entity
        return ResponseEntity.ok(loanService.getBorrowedBooks(new User(borrowerId)));
    }*/
}
