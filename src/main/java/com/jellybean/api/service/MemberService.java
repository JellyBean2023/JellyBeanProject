package com.jellybean.api.service;

import com.jellybean.api.dto.response.MemberResponse;
import com.jellybean.api.entity.Member;
import com.jellybean.api.repository.KdtMemberRepository;
import com.jellybean.api.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final KdtMemberRepository kdtMemberRepository;

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

//    public KdtMemberResponse getKdtMember(String email)  {
//        return memberRepository.findByEmail(email);
//    }

   /* public List<KdtMemberResponse> getKdtMember(String email) {
        List<Member> members = kdtMemberRepository.findByEmail(email);
        return members.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
*/
   /* private KdtMemberResponse convertToDto(Member member) {
        KdtMemberResponse kdtMemberResponse = new KdtMemberResponse();
        kdtMemberResponse.setEmail(member.getEmail());
        kdtMemberResponse.setName(member.getName());
        kdtMemberResponse.setBirth(member.getBirth());
        return kdtMemberResponse;
    }*/

}
