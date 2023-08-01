package com.jellybean.api.controller;

import com.jellybean.api.dto.response.KdtMemberResponse;
import com.jellybean.api.dto.response.MypageResponse;
import com.jellybean.api.service.KdtAppService;
import com.jellybean.api.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageService;
    private final KdtAppService kdtAppService;

    @GetMapping("/mypage/{email}")
    public MypageResponse findMemberInfoByEmail(@PathVariable String email) {
        return mypageService.findMemberInfoByEmail(email);
    }

    @GetMapping("/mypage/kdt/{email}")
    public KdtMemberResponse findKdtInfoByEmail(@PathVariable String email)  {
        return mypageService.findKdtInfoByEmail(email);
    }
}
