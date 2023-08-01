package com.jellybean.api.controller;

import com.jellybean.api.entity.LecturesEntity;
import com.jellybean.api.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/{updateId}") //
    public ResponseEntity<Boolean> updatePage(@PathVariable("updateId") String id, @RequestBody Map<Long, Map<String, Object>> idToUpdate) throws IllegalAccessException {

        if(id.equals("curriculumbox")){
            adminService.updateLectures(idToUpdate);
        }
        else if(id.equals("section1")){
            adminService.updateSection1(idToUpdate);
        }

        return ResponseEntity.ok(true);
    }

    @GetMapping("")    //모든 과정 조회
    public ResponseEntity<List<String>> getAdminLectures() throws IllegalAccessException {
        List<String> lectures = adminService.getAdminLectures();
        for (String lecture : lectures) {
            System.out.println(lecture);
        }
        return ResponseEntity.ok().body(lectures);
    }



}
