package ch05.com.springrecipes.court.controller;

import ch05.com.springrecipes.court.service.ReservationService;
import ch05.com.springrecipes.court.Delayer;
import ch05.com.springrecipes.court.domain.Reservation;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationQueryController {

    private final ReservationService reservationService;
    private final AsyncListenableTaskExecutor taskExecutor;
    //private final TaskExecutor taskExecutor;

/*    public ReservationQueryController(ReservationService reservationService, AsyncTaskExecutor taskExecutor) {
        this.reservationService = reservationService;
        this.taskExecutor =taskExecutor;
    }*/

    public ReservationQueryController(ReservationService reservationService, AsyncListenableTaskExecutor taskExecutor) {
        this.reservationService = reservationService;
        this.taskExecutor = taskExecutor;
    }

    @GetMapping
    public void setupForm() {}

    @PostMapping
    public Callable<String> submitForm(@RequestParam("courtName") String courtName, Model model) {
        return () -> {
            List<Reservation> reservations = java.util.Collections.emptyList();
            if (courtName != null) {
                Delayer.randomDelay();
                reservations = reservationService.query(courtName);
            }
            model.addAttribute("reservations", reservations);
            return "reservationQuery";
        };
    }

    @PostMapping
    public DeferredResult<String> submitForm2(@RequestParam("counrtName") String courtName, Model model){
        final DeferredResult<String> result = new DeferredResult<>();

        taskExecutor.execute(() -> {
            List<Reservation> reservations = java.util.Collections.emptyList();
            if(courtName != null){
                Delayer.randomDelay();
                reservations = reservationService.query(courtName);
            }
            model.addAttribute("reservations", reservations);
            result.setResult("reservationQuery");
        });
        return result;
    }

    @PostMapping
    public CompletableFuture<String> submitForm3(@RequestParam("courtName") String courtName, Model model) {

        return CompletableFuture.supplyAsync(() -> {
            List<Reservation> reservations = java.util.Collections.emptyList();
            if(courtName != null){
                Delayer.randomDelay();
                reservations = reservationService.query(courtName);
            }
            model.addAttribute("reservations", reservations);
            return "reservationQuery";
        }, taskExecutor);
    }

    @PostMapping
    public ListenableFuture<String> submitForm4(@RequestParam("courtName") String courtName, Model model) {

        return taskExecutor.submitListenable(() -> {
            List<Reservation> reservations = java.util.Collections.emptyList();
            if(courtName != null){
                Delayer.randomDelay();
                reservations = reservationService.query(courtName);
            }
            model.addAttribute("reservations", reservations);
            return "reservationQuery";
        });
    }

}
