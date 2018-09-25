package ch03.com.springrecipes.court.service;

import ch03.com.springrecipes.court.domain.PeriodicReservation;
import ch03.com.springrecipes.court.domain.Player;
import ch03.com.springrecipes.court.domain.Reservation;
import ch03.com.springrecipes.court.domain.SportType;
import ch03.com.springrecipes.court.web.ReservationNotAvailableException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    public static final SportType TENNIS = new SportType(1, "Tennis");
    public static final SportType SOCCER = new SportType(2, "Soccer");

    private final List<Reservation> reservations = new ArrayList<>();

    // DB 연동 대신 하드코딩
    public ReservationServiceImpl() {
        reservations.add(new Reservation("Tennis #1", LocalDate.of(2008, 1, 14), 16, new Player("Roger", "N/A"), TENNIS));
        reservations.add(new Reservation("Tennis #2", LocalDate.of(2008, 1, 14), 20, new Player("James", "N/A"), TENNIS));
    }

    @Override
    public List<Reservation> query(String courName) {
        return this.reservations.stream()
                .filter(reservation -> Objects.equals(reservation.getCourtName(), courName))
                .collect(Collectors.toList());
    }

    @Override
    public void make(Reservation reservation) throws ReservationNotAvailableException {
        long cnt = reservations.stream()
                .filter(made -> Objects.equals(made.getCourtName(), reservation.getCourtName()))
                .filter(made -> Objects.equals(made.getDate(), reservation.getDate()))
                .filter(made -> made.getHour() == reservation.getHour())
                .count();

        if (cnt > 0) {
            throw new ReservationNotAvailableException(reservation.getCourtName(), reservation.getDate(), reservation.getHour());
        } else {
            reservations.add(reservation);
        }
    }

    @Override
    public List<SportType> getAllSportType() {
        return Arrays.asList(TENNIS, SOCCER);
    }

    @Override
    public SportType getSportType(int sportTypeId) {
        switch (sportTypeId) {
            case 1:
                return TENNIS;
            case 2:
                return SOCCER;
            default:
                return null;
        }
    }

    @Override
    public void makePeridoic(PeriodicReservation periodicReservation) throws ReservationNotAvailableException {
        LocalDate fromDate = periodicReservation.getFormDate();
        while(fromDate.isBefore(periodicReservation.getToDate())){
            Reservation reservation = new Reservation();
            reservation.setCourtName(periodicReservation.getCourtName());
            reservation.setDate(fromDate);
            reservation.setHour(periodicReservation.getHour());
            reservation.setPlayer(periodicReservation.getPlayer());
            make(reservation);

            fromDate = fromDate.plusMonths(periodicReservation.getPeriod());
        }
    }

    @Override
    public List<Reservation> findByDate(Date date) {
        return reservations.stream()
                .filter(r -> Objects.equals(r.getDate(), date))
                .collect(Collectors.toList());
    }
}
