package be.brussel.school.service;

import be.brussel.school.model.Book;
import be.brussel.school.model.Reservation;
import be.brussel.school.model.User;
import be.brussel.school.repository.BookRepository;
import be.brussel.school.repository.ReservationRepository;
import be.brussel.school.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;

    @Override
    public Reservation reserveBook(Long bookId, User borrower) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Reservation reservation = new Reservation();
        reservation.setBook(book);
        reservation.setBorrower(borrower);
        reservation.setReservationDate(LocalDate.now());
        reservation.setExpirationDate(LocalDate.now().plusDays(7));
        reservation.setFulfilled(false);

        return reservationRepository.save(reservation);
    }

    @Override
    public void fulfillReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setFulfilled(true);
        reservationRepository.save(reservation);
    }

    @Override
    public Optional<Reservation> getReservationsForBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return reservationRepository.findByBookAndFulfilledFalse(book);
    }
}
