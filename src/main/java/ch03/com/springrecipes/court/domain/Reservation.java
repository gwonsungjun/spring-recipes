package ch03.com.springrecipes.court.domain;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class Reservation {

    @NotNull
    @Size(min = 4)
    private String courtName;

    @NotNull
    private LocalDate date;

    @Min(9)
    @Max(21)
    private int hour;

    @Valid
    private Player player;

    @NotNull
    private SportType sportType;

    public Reservation() {}

    public Reservation(String courtName, LocalDate date, int hour, Player player, SportType sportType) {
        this.courtName = courtName;
        this.date = date;
        this.hour = hour;
        this.player = player;
        this.sportType = sportType;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public String getCourtName() {
        return courtName;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public Player getPlayer() {
        return player;
    }

    public SportType getSportType() {
        return sportType;
    }
}
