package com.jellybean.api.security;

import com.jellybean.api.entity.Member;
import com.jellybean.api.entity.MemberRole;
import com.jellybean.api.service.MemberService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MyUserDetailService implements UserDetailsService {

    private final MemberService memberService;

    public MyUserDetailService(MemberService memberService){
        this.memberService = memberService;
    }


    @Override
    public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
        Optional<Member> findOne = memberService.findOne(useremail);
        Member member = findOne.orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 회원입니다."));
        return org.springframework.security.core.userdetails.User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(String.valueOf(member.getRoleSet()))
                .build();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<MemberRole> roleSet){
        return roleSet.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

}
