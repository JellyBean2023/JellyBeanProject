package com.jellybean.api.service;

import com.jellybean.api.dto.response.KdtMemberResponse;
import com.jellybean.api.dto.response.MypageResponse;
import com.jellybean.api.entity.KdtAppEntitiy;
import com.jellybean.api.entity.Member;
import com.jellybean.api.repository.KdtAppRepository;
import com.jellybean.api.repository.MemberRepository;
import com.jellybean.api.repository.MypageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MypageRepository mypageRepository;

    private final MemberRepository memberRepository;
    private final KdtAppRepository kdtAppRepository;


    public MypageResponse findMemberInfoByEmail(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("유저 정보가 없습니다.")
        );

        return new MypageResponse(member.getEmail(), member.getName(), member.getBirth(), member.getPhone(), member.getAuthority(), member.getEmployeeNumber());
//        return member;
    }

    public KdtMemberResponse findKdtInfoByEmail(String email) {
        KdtAppEntitiy kdtmember = kdtAppRepository.findByEmail(email);;
        if (kdtmember == null) {
            return new KdtMemberResponse(false);
        }

        return new KdtMemberResponse(true, kdtmember.getName(), kdtmember.getEmail(), kdtmember.getPhoneNumber(), kdtmember.getPhoneNumberText(), kdtmember.getDate(), kdtmember.isAgreeCollect(), kdtmember.isAgreeThirdParty(), kdtmember.getExperience(), kdtmember.getExperienceText(), kdtmember.getFinalEducation(), kdtmember.getGetCard(), kdtmember.getGetEx(), kdtmember.getGrade(), kdtmember.getPathText()
                , kdtmember.getPaths(), kdtmember.getReason(), kdtmember.getRecommend(), kdtmember.getId());
    }
}
