package ch03.com.springrecipes.court.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    // == @RequestMapping(value = "/welcome", method=RequestMethod.GET), 클래스 레벨의 RequestMapping은 없음
    // == @GetMapping("/welcome"), 클래스 레벨의 RequestMapping은 없음
    public String welcome(Model model){

        Date today = new Date();
        model.addAttribute("today", today);
        return "welcome";

    }
}
