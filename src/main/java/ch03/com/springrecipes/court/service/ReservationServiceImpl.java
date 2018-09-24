package ch03.com.springrecipes.court.service;

import ch03.com.springrecipes.court.domain.Player;
import ch03.com.springrecipes.court.domain.Reservation;
import ch03.com.springrecipes.court.domain.SportType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{

    public static final SportType TENNIS = new SportType(1, "Tennis");
    public static final SportType SOCCER = new SportType(2, "Soccer");

    private final List<Reservation> reservations = new ArrayList<>();

    // DB 연동 대신 하드코딩
    public ReservationServiceImpl(){
        reservations.add(new Reservation("Tennis #1", LocalDate.of(2008, 1, 14), 16, new Player("Roger", "N/A"), TENNIS));
        reservations.add(new Reservation("Tennis #2", LocalDate.of(2008, 1, 14), 20, new Player("James", "N/A"), TENNIS));
    }

    @Override
    public List<Reservation> query(String courName) {
        return this.reservations.stream()
                .filter(reservation -> Objects.equals(reservation.getCourtName(), courName))
                .collect(Collectors.toList());
    }
}
