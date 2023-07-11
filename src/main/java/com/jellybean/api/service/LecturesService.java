package com.jellybean.api.service;

import com.jellybean.api.entity.LecturesEntity;
import com.jellybean.api.repository.LecturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturesService {
    @Autowired
    private LecturesRepository lecturesRepository;

    //과정별 조회
    public Optional<LecturesEntity> getLecturesByName(String lecName) throws IllegalAccessException {
        Optional<LecturesEntity> lectures = lecturesRepository.findByLecName(lecName);
        if( !lectures.isEmpty()) {
            return lectures;
        }
        else {
            throw new IllegalAccessException("no lectures found with the given name");
        }
    }

    //모든 과정 조회
    public List<LecturesEntity> getLectures() throws IllegalAccessException {
        List<LecturesEntity> lectures = lecturesRepository.findAll();

        if(!lectures.isEmpty()) return lecturesRepository.findAll();
        else throw new IllegalAccessException("no such data");
    }

    /*
    public LecturesEntity getLectureById(final Long lecId) throws IllegalAccessException {
        return lecturesRepository.findById(lecId).orElseThrow(()-> new IllegalAccessException("no such data"));
    }

    //과정 추가
    public LecturesEntity createLecture(final LecturesEntity createLectureEntity) throws IllegalAccessException {
        if(createLectureEntity == null) throw new IllegalAccessException("Lectures cannot be null");
        return lecturesRepository.save(createLectureEntity);
    }

    //과정 수정
    public LecturesEntity updateLecture(final long lecId, final LecturesEntity updateLectureEntity) throws IllegalAccessException {
        LecturesEntity lecturesEntity = getLectureById(lecId);
        lecturesEntity.setLecStatus(updateLectureEntity.getLecStatus());
        lecturesEntity.setLecName(updateLectureEntity.getLecName());
        lecturesEntity.setLecInfo(updateLectureEntity.getLecInfo());

        return lecturesRepository.save(updateLectureEntity);
    }

    //과정 삭제
    public void deleteLectureById(final Long lecId) {
        lecturesRepository.deleteById(lecId);
    }
    */
}
