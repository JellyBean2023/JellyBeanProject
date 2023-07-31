package com.jellybean.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KdtMemberResponse {

    private String email;
    private String name;
    private String birth;

//    public static KdtMemberResponse kdtMemberResponse(Member member) {
//        return new KdtMemberResponse(member.getEmail(), member.getName(), member.getBirth());
//    }

}
