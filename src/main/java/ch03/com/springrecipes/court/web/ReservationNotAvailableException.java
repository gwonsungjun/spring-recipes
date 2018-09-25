package ch03.com.springrecipes.court.web;

import java.time.LocalDate;

public class ReservationNotAvailableException extends RuntimeException {

    private String courtName;
    private LocalDate date;
    private int hour;

    public ReservationNotAvailableException(String courtName, LocalDate date, int hour) {
        this.courtName = courtName;
        this.date = date;
        this.hour = hour;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
