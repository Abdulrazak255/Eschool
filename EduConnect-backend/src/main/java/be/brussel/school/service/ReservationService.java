package be.brussel.school.service;

import be.brussel.school.model.Reservation;
import be.brussel.school.model.User;

import java.util.Optional;

public interface ReservationService {
    Reservation reserveBook(Long bookId, User borrower);
    void fulfillReservation(Long reservationId);
    Optional<Reservation> getReservationsForBook(Long bookId);
}
