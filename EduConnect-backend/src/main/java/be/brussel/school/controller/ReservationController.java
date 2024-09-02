package be.brussel.school.controller;

import be.brussel.school.model.Reservation;
import be.brussel.school.model.User;
import be.brussel.school.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reserve")
    public ResponseEntity<Reservation> reserveBook(@RequestParam Long bookId, @RequestBody User borrower) {
        return ResponseEntity.ok(reservationService.reserveBook(bookId, borrower));
    }

    @PutMapping("/{reservationId}/fulfill")
    public ResponseEntity<Void> fulfillReservation(@PathVariable Long reservationId) {
        reservationService.fulfillReservation(reservationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Optional<Reservation>> getReservationsForBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(reservationService.getReservationsForBook(bookId));
    }
}
