package ch05.com.springrecipes.court.service;

import ch05.com.springrecipes.court.domain.PeriodicReservation;
import ch05.com.springrecipes.court.domain.Reservation;
import ch05.com.springrecipes.court.domain.SportType;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    List<Reservation> query(String courtName);

    void make(Reservation reservation)
            throws ReservationNotAvailableException;

    List<SportType> getAllSportTypes();

    SportType getSportType(int sportTypeId);

    List<Reservation> findByDate(LocalDate summaryDate);

    void makePeriodic(PeriodicReservation periodicReservation)
            throws ReservationNotAvailableException;
}
