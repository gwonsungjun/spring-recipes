package ch03.com.springrecipes.court.controller;

import ch03.com.springrecipes.court.service.ReservationNotAvailableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {

    // HandlerExceptionResolver를 구성하지 않고 메서드에 @ExceptionHandler를 붙여서 예외 핸들러 매핑
    // 단점은 해당 컨트롤러 안에서만 유효함. 따라서 @ControllerAdvice 사용
    @ExceptionHandler(ReservationNotAvailableException.class)
    public String handle(ReservationNotAvailableException ex){
        return "reservationNotAvailable";
    }

    @ExceptionHandler
    public String handleDefault(Exception e){
        return "error";
    }
}
