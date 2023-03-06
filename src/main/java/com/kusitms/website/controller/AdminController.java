package com.kusitms.website.controller;

import com.kusitms.website.common.BaseResponse;
import com.kusitms.website.dto.meetup.MeetupRequest;
import com.kusitms.website.service.MeetupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final MeetupService meetupService;

    @PostMapping(value = "/meetup")
    public ResponseEntity<BaseResponse> saveMeetup(@RequestPart(value="meetup_request", required=true) MeetupRequest request,
                                                   @RequestPart(value="logo_file", required=true) MultipartFile logoFile,
                                                   @RequestPart(value="poster_file", required=true) MultipartFile posterFile) throws IOException {
        meetupService.save(request, logoFile, posterFile);
        return ResponseEntity.ok(new BaseResponse());
    }
}
