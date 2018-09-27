package ch04.com.springrecipes.court.controller;

import ch04.com.springrecipes.court.domain.Member;
import ch04.com.springrecipes.court.domain.Members;
import ch04.com.springrecipes.court.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RestMemberController {

    private final MemberService memberService;

    @Autowired
    public RestMemberController(MemberService memberService){
        this.memberService = memberService;
    }

/*    @RequestMapping(value = "/members", produces = MediaType.APPLICATION_XML_VALUE)
    //@ResponseBody
    public String getRestMemberXml(Model model){
        Members members = new Members();
        members.addMembers(memberService.findAll());
        model.addAttribute("members", members);
        //return "membertemplate";
        //return "members";
        return "xmlmembertemplate";
    }

    @RequestMapping(value = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRestMemberJson(Model model) {
        Members members = new Members();
        members.addMembers(memberService.findAll());
        model.addAttribute("members", members);
        return "jsonmembertemplate";
    }*/

    @RequestMapping("/members")
    @ResponseBody
    public Members getRestMembers() {
        Members members = new Members();
        members.addMembers(memberService.findAll());
        return members;
    }

    @RequestMapping("/member/{memberid}")
    public ResponseEntity<Member> getMember(@PathVariable("memberid") long memberID) {
        Member member = memberService.find(memberID);
        if (member != null) {
            return new ResponseEntity<Member>(member, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dataFormat, false));
    }

    @RequestMapping("/reservations/{date}")
    public void getReservation(@PathVariable("date") Date resDate) {

    }
}
