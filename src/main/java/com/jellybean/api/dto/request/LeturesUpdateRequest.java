package com.jellybean.api.dto.request;

import com.jellybean.api.entity.LecturesEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeturesUpdateRequest {

    private Long lecId;
    private String lecName;
    private String cardinalName;
    private String lecStatus;
    private String lecInfo;

    public LecturesEntity toLectures() {
        return LecturesEntity.builder()
                .lecId(lecId)
                .lecName(lecName)
                .cardinalName(cardinalName)
                .lecStatus(lecStatus)
                .lecInfo(lecInfo)
                .build();
    }

}
