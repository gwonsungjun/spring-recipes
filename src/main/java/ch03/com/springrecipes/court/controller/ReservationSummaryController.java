package ch03.com.springrecipes.court.controller;

import ch03.com.springrecipes.court.domain.Reservation;
import ch03.com.springrecipes.court.service.ReservationService;
import ch03.com.springrecipes.court.web.ReservationWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservationSummary*")
public class ReservationSummaryController {

    private ReservationService reservationService;

    @Autowired
    public ReservationSummaryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String generateSummary(@RequestParam(required = true, value = "date") String selectDate, Model model) {
        List<Reservation> reservations = java.util.Collections.emptyList();
        try {
            Date summaryDate = new SimpleDateFormat("yyyy-MM-dd").parse(selectDate);
            reservations = reservationService.findByDate(summaryDate);
        } catch (java.text.ParseException ex) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace();
            throw new ReservationWebException("Invalid date format for reservation summary", new Date(), sw.toString());
        }
        model.addAttribute("reservations", reservations);
        return "reservationSummary";
    }
}
