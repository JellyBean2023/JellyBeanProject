package com.jellybean.api.service;

import com.jellybean.api.entity.Member;
import com.jellybean.api.repository.MemberRepository;
import com.jellybean.api.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse findMemberInfoById(Long memberId) {
        return memberRepository.findById(memberId)
            .map(MemberResponse::memberResponse)
            .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }

    public MemberResponse findMemberInfoByEmail(String email) {
        return memberRepository.findByEmail(email)
            .map(MemberResponse::memberResponse)
            .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }


    public boolean isEmailDuplicated(String email) {
        Optional<Member> existingMember = memberRepository.findByEmail(email);
        return existingMember.isPresent();
    }

}
