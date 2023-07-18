package com.jellybean.api.service;

import com.jellybean.api.dto.MemberJoinDto;
import com.jellybean.api.entity.Member;
import com.jellybean.api.entity.MemberRole;
import com.jellybean.api.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final ModelMapper modelMapper;

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean isValidMember(String email, String password) {
        return false;
    }

    @Override
    public Optional<Member> findOne(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public void join(MemberJoinDto memberJoinDto) throws MemberService.MidExistException{
        String email = memberJoinDto.getEmail();
        boolean exist = memberRepository.existsByEmail(email);

        if(exist){
            throw new MemberService.MidExistException();
        }

        Member member = modelMapper.map(memberJoinDto, Member.class);
        member.changePassword(passwordEncoder.encode(memberJoinDto.getPassword()));
        member.addRole(MemberRole.USER);

        log.info("==============");
        log.info(member);
        log.info(member.getRoleSet());

        memberRepository.save(member);
    }

    @Override
    public void loadMemberWithRoles(String email) {
        Optional<Member> memberOptional = memberRepository.findByEmail(email);
        if(memberOptional.isPresent()){
            Member member = memberOptional.get();
            member.getRoleSet().size();
        }
    }


}
