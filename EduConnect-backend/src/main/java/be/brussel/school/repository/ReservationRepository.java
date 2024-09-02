package be.brussel.school.repository;

import be.brussel.school.model.Book;
import be.brussel.school.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByBorrowerId(Long borrowerId);

    List<Reservation> findByBookId(Long bookId);
    Optional<Reservation> findByBookAndFulfilledFalse(Book book);

    List<Reservation> findByFulfilled(boolean fulfilled);

    List<Reservation> findByExpirationDateBefore(LocalDate date);
}
