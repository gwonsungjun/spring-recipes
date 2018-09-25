package ch03.com.springrecipes.court.controller;

import ch03.com.springrecipes.court.domain.Player;
import ch03.com.springrecipes.court.domain.Reservation;
import ch03.com.springrecipes.court.domain.SportType;
import ch03.com.springrecipes.court.service.ReservationService;
import ch03.com.springrecipes.court.service.ReservationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {

    private final ReservationService reservationService;
    private ReservationValidator reservationValidator;

    @Autowired
    public ReservationFormController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    // 모든 핸들러 메스다가 반환하는 뷰에서 공통적으로 쓸 수 있는 전역 모델 속성을 정의하는 애너테이션
    @ModelAttribute("sportTypes")
    public List<SportType> populateSportTypes(){
        return reservationService.getAllSportType();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(@RequestParam(required = false, value = "username") String username, Model model){
        Reservation reservation = new Reservation();
        reservation.setPlayer(new Player(username, null));
        model.addAttribute("reservation", reservation);
        return "reservationForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("reservation") @Validated Reservation reservation, BindingResult result, SessionStatus status){
        if (result.hasErrors()) {
            return "reservationForm";
        } else{
            reservationService.make(reservation);
            status.setComplete();
            // PRG Pattern (중복 폼 전송 문제 방지)
            return "redirect:reservationSuccess";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(reservationValidator);
    }


    /*// HandlerExceptionResolver를 구성하지 않고 메서드에 @ExceptionHandler를 붙여서 예외 핸들러 매핑
    // 단점은 해당 컨트롤러 안에서만 유효함. 따라서 @ControllerAdvice 사용
    @ExceptionHandler(ReservationNotAvailableException.class)
    public String handle(ReservationNotAvailableException ex){
        return "reservationNotAvailable";
    }

    @ExceptionHandler
    public String handleDefault(Exception e){
        return "error";
    }*/
}
