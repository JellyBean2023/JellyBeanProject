package com.jellybean.api.controller;


import com.jellybean.api.Vo.EmaillRequest;
import com.jellybean.api.Vo.UserRequest;
import com.jellybean.api.service.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class EmailController {

    @Autowired
    private final EmailServiceImpl emailService;

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signup(@RequestBody UserRequest userRequest) {

        //이메일 중복 확인
        boolean isEmailDuplicated = memberService.isEmailDuplicated(userRequest.getEmail());
        if(isEmailDuplicated){
            return ResponseEntity.badRequest().body(false);
        }

        //회원가입 성공 처리
        MemberResponse response = authService.signup(userRequest);
        return ResponseEntity.ok(true);
//        return ResponseEntity.ok(authService.signup(memberRequest));
    }

    //    @PostMapping("/signup")
//    public ResponseEntity<MemberResponse> signup(@RequestBody MemberRequest memberRequest) {
//
//        //이메일 중복 확인
//        boolean isEmailDuplicated = memberService.isEmailDuplicated(memberRequest.getEmail());
//        if(isEmailDuplicated){
//            return ResponseEntity.badRequest().body(new MemberResponse("false"));
//        }
//
//        //회원가입 성공 처리
//        MemberResponse response = authService.signup(memberRequest);
//        return ResponseEntity.ok(response);
////        return ResponseEntity.ok(authService.signup(memberRequest));
//    }

    @PostMapping("/regist/emailConfirm")
    public String emailConfirm(@RequestParam String email) throws Exception {
        String code = emailService.sendSimpleMessage(email);
        return code;
    }

    @PostMapping("/regist/emailCheck")
    public ResponseEntity<?> emailCheck(@RequestBody EmaillRequest request) throws IOException {
        try {
            boolean isVerified = emailService.checker(request.getEmail(), request.getCode());
            if (isVerified) {
                //return ResponseEntity.ok("Verification code is correct.");
                return ResponseEntity.ok("true");
            } else {
              //  return ResponseEntity.badRequest().body("Verification code is incorrect.");
                return ResponseEntity.badRequest().body("false");
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Email not found in the database.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred.");
        }
    }

}
