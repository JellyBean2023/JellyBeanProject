package com.jellybean.api.security;

import com.jellybean.api.entity.Member;
import com.jellybean.api.repository.MemberRepository;
import com.jellybean.api.security.dto.MemberSecurityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService {
}
//public class CustomUserDetailsService implements UserDetailsService {

//    private PasswordEncoder passwordEncoder;
//
//    public CustomUserDetailsService() {
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }

//    private final MemberRepository memberRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        log.info("loadUserByUsername: " + username);
//
//        Optional<Member> result = memberRepository.getWithRoles(username);
//
//        if(result.isEmpty()){
//            throw new UsernameNotFoundException("username not found...");
//        }
//
//        Member member = result.get();
//
//        MemberSecurityDTO memberSecurityDTO = new MemberSecurityDTO(
//                member.getName(),
//                member.getEmail(),
//                member.getPassword(),
//                member.getDateOfBirth(),
//                member.getPhoneNumber(),
//                member.isDel(),
//                member.getRoleSet().stream().map(roleSet -> new SimpleGrantedAuthority("ROLE_" + roleSet.name()))
//                        .collect(Collectors.toList())
//        );
//
//        log.info("memberSecurityDTO");
//        log.info(memberSecurityDTO);
//
//        return memberSecurityDTO;
//    }

