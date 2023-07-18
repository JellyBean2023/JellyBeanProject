package com.jellybean.api.controller;

import com.jellybean.api.dto.MemberJoinDto;
import com.jellybean.api.dto.MemberLoginDto;
import com.jellybean.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginGET(String error, String logout){
        log.info("login get.......");
        log.info("logout: " + logout);

        if(logout != null){
            log.info("user logout......");
        }
        return "login";
    }

    @PostMapping("/login-process")
    public String login(MemberLoginDto memberLoginDto) {
        boolean isValidMember = memberService.isValidMember(memberLoginDto.getEmail(), memberLoginDto.getPassword());
        if(isValidMember){
            return "login..fail..";
        }
        return "login sucess";
    }



    @GetMapping("/join")
    public void joinGET(){
        log.info("join get.........");

    }

    @PostMapping("/join")
    public String joinPOST(MemberJoinDto memberJoinDTO, RedirectAttributes redirectAttributes){

        log.info("join post....");
        log.info(memberJoinDTO);

        try{
            memberService.join(memberJoinDTO);
        }catch (MemberService.MidExistException e){
            redirectAttributes.addFlashAttribute("error", "email");
            return "redirect:/hello";
        }

        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/member/login";

    }

    @GetMapping("/hello")
    public String mainPage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("loginEmail", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());
        return "hello";
    }

    @GetMapping("/setting/admin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String adminSettingPage(){
        return "admin_setting";
    }

    @GetMapping("/setting/user")
    @PreAuthorize("hasAnyRole('USER')")
    public String userSettingPage(){
        return "user_setting";
    }


}
