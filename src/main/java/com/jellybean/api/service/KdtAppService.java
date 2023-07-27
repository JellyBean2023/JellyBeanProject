package com.jellybean.api.service;

import com.jellybean.api.Vo.KdtAppRequest;
import com.jellybean.api.entity.KdtAppEntitiy;
import com.jellybean.api.repository.KdtAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KdtAppService {
    @Autowired
    private KdtAppRepository kdtAppRepository;

    public String application(KdtAppRequest request) throws AlreadyExistException{
        try {
            kdtAppRepository.save(
                    KdtAppEntitiy.builder()
                            .name(request.getName())
                            .email(request.getEmail())
                            .phoneNumber(request.getPhoneNumber())
                            .phoneNumberText(request.getPhoneNumberText())
                            .date(request.getDate())
                            .agreeCollect(request.isAgreeCollect())
                            .agreeThirdParty(request.isAgreeThirdParty())
                            .experience(request.getExperience())
                            .experienceText(request.getExperienceText())
                            .finalEducation(request.getFinalEducation())
                            .getCard(request.getGetCard())
                            .getEx(request.getGetEx())
                            .grade(request.getGrade())
                            .pathText(request.getPathText())
                            .paths(request.getPaths())
                            .reason(request.getReason())
                            .recommend(request.getRecommend())
                            .id(request.getId())
                            .build()
            );
            return "Success";
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistException("already exists", e);
        }
    }
}
