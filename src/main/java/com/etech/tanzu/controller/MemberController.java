package com.etech.tanzu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etech.tanzu.domain.Member;
import com.etech.tanzu.service.MemberService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "members", description = "회원 API")
@Controller
public class MemberController {
    
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        
        return "members/memberList";
    }

    @GetMapping("/members/test")
    @ResponseBody
    public String test() {
        return "this is test";
    }

    @GetMapping("/members/test-api")
    @ResponseBody
    public String testApi() {
        return "this is test-api";
    }
    
}
