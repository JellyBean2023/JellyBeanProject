package com.jellybean.api.controller;


import com.jellybean.api.dto.TokenDto;
import com.jellybean.api.dto.request.MemberRequest;
import com.jellybean.api.dto.request.TokenRequest;
import com.jellybean.api.dto.response.MemberResponse;
import com.jellybean.api.dto.response.TokenResponse;
import com.jellybean.api.service.AuthService;
import com.jellybean.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final MemberService memberService;


    @PostMapping("/signup/emailcheck")
    public ResponseEntity<Boolean> emailcheck(@RequestBody MemberRequest memberRequest) {

        //이메일 중복 확인
        boolean isEmailDuplicated = memberService.isEmailDuplicated(memberRequest.getEmail());
        if (isEmailDuplicated) {
            return ResponseEntity.badRequest().body(false);
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> signup(@RequestBody MemberRequest memberRequest) {

        //회원가입 성공 처리
//        MemberResponse response = authService.signup(memberRequest);
//        return ResponseEntity.ok(true);
        return ResponseEntity.ok(authService.signup(memberRequest));
    }


    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody MemberRequest memberRequest) {

        TokenDto tokenDto = authService.login(memberRequest);
        Boolean isAdmin = authService.getAdminCheck(memberRequest);
        TokenResponse tokenResponse = new TokenResponse(tokenDto, isAdmin);

        return ResponseEntity.ok(tokenResponse);
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequest tokenRequest) {
        return ResponseEntity.ok(authService.reissue(tokenRequest));
    }

    @DeleteMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody MemberRequest memberRequest, @RequestBody TokenDto tokenDto){
        return ResponseEntity.ok(authService.logout(tokenDto.getAccessToken(), memberRequest.toMember()));
    }


}