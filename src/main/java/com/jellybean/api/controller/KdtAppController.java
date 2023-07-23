package com.jellybean.api.controller;

import com.jellybean.api.Vo.KdtAppRequest;
import com.jellybean.api.service.AlreadyExistException;
import com.jellybean.api.service.KdtAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class KdtAppController {
    private final KdtAppService kdtAppService;

    @PostMapping("/kdtapp")
    public String application(@RequestBody KdtAppRequest request) throws IOException {
        try {
            return kdtAppService.application(request);
        } catch (AlreadyExistException e) {
            throw new RuntimeException(e);
        }
    }
}
