package com.jellybean.api.controller;


import com.jellybean.api.dto.TokenDto;
import com.jellybean.api.dto.request.MemberRequest;
import com.jellybean.api.dto.request.TokenRequest;
import com.jellybean.api.dto.response.MemberResponse;
import com.jellybean.api.entity.Member;
import com.jellybean.api.service.AuthService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> signup(@RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok(authService.signup(memberRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok(authService.login(memberRequest));
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