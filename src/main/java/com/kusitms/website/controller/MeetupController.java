package com.kusitms.website.controller;

import com.kusitms.website.common.BaseResponse;
import com.kusitms.website.service.MeetupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class MeetupController {
    private final MeetupService meetupService;

    @GetMapping()
    public ResponseEntity<BaseResponse> getMeetupProjects() {
        return ResponseEntity.ok(new BaseResponse(meetupService.getMeetupProjects()));
    }

    @GetMapping("/{meetup_id}")
    public ResponseEntity<BaseResponse> getMeetupProject(@PathVariable(name = "meetup_id") Long meetupId) {
        return ResponseEntity.ok(new BaseResponse(meetupService.getMeetupProject(meetupId)));
    }
}
