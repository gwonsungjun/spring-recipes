package ch03.com.springrecipes.court.web;

import java.util.Date;

public class ReservationWebException extends RuntimeException {
    private String message;
    private String stack;
    private Date date;

    public ReservationWebException(String message, Date date, String stack) {
        this.message = message;
        this.date = date;
        this.stack = stack;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public String getStack() {
        return stack;
    }
}
