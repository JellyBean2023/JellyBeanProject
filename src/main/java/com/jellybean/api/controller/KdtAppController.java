package com.jellybean.api.controller;

import com.jellybean.api.Vo.KdtAppRequest;
import com.jellybean.api.dto.request.KdtMemberRequest;
import com.jellybean.api.dto.response.KdtMemberResponse;
import com.jellybean.api.service.AlreadyExistException;
import com.jellybean.api.service.KdtAppService;
import com.jellybean.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class KdtAppController {
    private final KdtAppService kdtAppService;
    private final MemberService memberService;

    @PostMapping("/kdtapp")
    public String application(@RequestBody KdtAppRequest request) throws IOException {
        try {
            return kdtAppService.application(request);
        } catch (AlreadyExistException e) {
            throw new RuntimeException(e);
        }
    }

//    @GetMapping("/api/kdt/member")
//    public ResponseEntity<KdtMemberResponse> () {
//        String getEmail = memberService.getKdtMemberByEmail();
//        return KdtMemberResponse.kdtMemberResponse()
//    }

    @PostMapping("api/kdt/member")
    public ResponseEntity<List<KdtMemberResponse>> KdtMemberInfo(@RequestBody KdtMemberRequest kdtMemberRequest) {
        List<KdtMemberResponse> members = memberService.getKdtMember(kdtMemberRequest.getEmail());
        return ResponseEntity.ok(members);
    }

}
