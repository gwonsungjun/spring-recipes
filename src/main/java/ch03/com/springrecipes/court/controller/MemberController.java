/*
package ch03.com.springrecipes.court.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // @RequestMapping("/member/add")
    @RequestMapping("add")
    public String addMember(Model model){
        model.addAttribute("member", new Member());
        model.addAttribute("guests", memberService.list());
        return "memberList";
    }

    // @RequestMapping(value = {"/member/remove", "/member/delete"}, Method = RequestMethod.GET)
    @RequestMapping(value = {"remove", "delete"}, Method = RequestMethod.GET)
    public String removeMember(@RequestParam("memberName") String memberName) {
        memberService.remove(memberName);
        return "redirect:";
    }

    // REST형 웹 서비스 설계시 유용한 기법
    // URL안에 포함된 값을 핸들러 메서드의 입력 매개변숫값으로 전달하겠다는 의미
    @RequestMapping("display/{member}")
    public String displayMember(@PathVariable("member") String member, Model model){
        model.addAttribute("member", memberService.find(member).orElse(null));
        return "member";
    }

    // 다른 메서드에 걸리지 않은 모든 요청이 들어오면 이 메서드가 실행된다.
    // 반환값 void 따라서 memberList로 제어권 넘김.
    @RequestMapping
    public void memberList(){}

    // 스프링 MVC와 무관한 이 클래스 내부에서만 사용되는 유틸리티.
    public void memberLogic(String memberName){}
}
*/
