package ch03.com.springrecipes.court.service;

import ch03.com.springrecipes.court.domain.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> query(String courName);
}
