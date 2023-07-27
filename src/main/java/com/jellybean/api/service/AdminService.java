package com.jellybean.api.service;

import com.jellybean.api.entity.LecturesEntity;
import com.jellybean.api.repository.LecturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private LecturesRepository lecturesRepository;


    //세션1 수정
    public boolean updateSection1(Map<Long, Map<String, Object>> section1ToUpdate) {
        for (Map.Entry<Long, Map<String, Object>> entry : section1ToUpdate.entrySet()) {
            Long sec1Id = entry.getKey();
            Map<String, Object> section1Info = entry.getValue();


            // 프론트에서 받은 JSON의 각 키와 값들로 업데이트
            for (Map.Entry<String, Object> infoEntry : section1Info.entrySet()) {
                String key = infoEntry.getKey();
                Object value = infoEntry.getValue();

                switch (key) {
                    case "sec1Name":
                        String sec1Name = (String) value;
                        System.out.println("Section1 ID: " + sec1Id + ", sec1Name: " + sec1Name);
                        break;
                    case "sec1Status":
                        String sec1Status = (String) value;
                        System.out.println("Section1 ID: " + sec1Id + ", sec1Status: " + sec1Status);
                        break;
                    case "sec1Info":
                        String sec1Info = (String) value;
                        System.out.println("Section1 ID: " + sec1Id + ", sec1Info: " + sec1Info);
                        break;
                    default:
                        break;
                }
            }
        }

        return true;
    }

    //과정 수정
    public boolean updateLectures(Map<Long, Map<String, Object>> lecturesToUpdate) throws IllegalAccessException {
        for (Map.Entry<Long, Map<String, Object>> entry : lecturesToUpdate.entrySet()) {
            Long lecId = entry.getKey();
            Map<String, Object> lectureInfo = entry.getValue();

            LecturesEntity updateLectureEntity = lecturesRepository.findById(lecId)
                    .orElseThrow(() -> new IllegalArgumentException("해당 ID에 해당하는 강의를 찾을 수 없습니다: " + lecId));

            // 프론트에서 받은 JSON의 각 키와 값들로 업데이트
            for (Map.Entry<String, Object> infoEntry : lectureInfo.entrySet()) {
                String key = infoEntry.getKey();
                Object value = infoEntry.getValue();

                switch (key) {
                    case "lecName":
                        updateLectureEntity.setLecName((String) value);
                        break;
                    case "cardinalName":
                        updateLectureEntity.setCardinalName((String) value);
                        break;
                    case "lecStatus":
                        updateLectureEntity.setLecStatus((String) value);
                        break;
                    case "lecInfo":
                        updateLectureEntity.setLecInfo((String) value);
                        break;
                    default:
                        break;
                }
            }

            lecturesRepository.save(updateLectureEntity);
        }

        return true;
    }



}




