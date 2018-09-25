package ch03.com.springrecipes.court.service;

import ch03.com.springrecipes.court.domain.PeriodicReservation;
import ch03.com.springrecipes.court.domain.Reservation;
import ch03.com.springrecipes.court.domain.SportType;
import ch03.com.springrecipes.court.web.ReservationNotAvailableException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationService {
    public List<Reservation> query(String courName);
    void make(Reservation reservation) throws ReservationNotAvailableException;
    public List<SportType> getAllSportType();
    public SportType getSportType(int sportTypeId);
    public void makePeridoic(PeriodicReservation periodicReservation) throws ReservationNotAvailableException;
    public List<Reservation> findByDate(Date date);
}
