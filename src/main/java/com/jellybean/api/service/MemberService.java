package com.jellybean.api.service;

import com.jellybean.api.dto.MemberJoinDto;
import com.jellybean.api.entity.Member;

import java.util.Optional;

public interface MemberService {


    boolean isValidMember(String email, String password);
    Optional<Member> findOne(String email);

    static class MidExistException extends Exception {

    }

    void join(MemberJoinDto memberJoinDto) throws MidExistException;

    public void loadMemberWithRoles(String email);

}
