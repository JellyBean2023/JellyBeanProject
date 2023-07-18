package com.jellybean.api.controller;

import com.jellybean.api.dto.MemberJoinDto;
import com.jellybean.api.service.RegisterMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    private final RegisterMemberService registerMemberService;

    public AuthorizationController(RegisterMemberService registerMemberService){
        this.registerMemberService = registerMemberService;
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberJoinDto memberJoinDto){
        try{
            registerMemberService.join(memberJoinDto.getName(), memberJoinDto.getEmail(), memberJoinDto.getPassword()
            , memberJoinDto.getDateOfBirth(), memberJoinDto.getPhoneNumber(), memberJoinDto.isDel(), memberJoinDto.getRegDate(), memberJoinDto.getRoleSet());
            return ResponseEntity.ok("join success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
