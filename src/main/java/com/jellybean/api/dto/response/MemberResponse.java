package com.jellybean.api.dto.response;

import com.jellybean.api.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {

    private String email;
    private String name;
    private String birth;

    public static MemberResponse memberResponse(Member member) {
        return new MemberResponse(member.getEmail(), member.getName(), member.getBirth());
    }


//    private boolean success;
//
//    public static MemberResponse memberResponse(Member member){
//        return new MemberResponse(member.getSuccess)
//    }

}