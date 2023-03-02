package com.kusitms.website.controller;

import com.kusitms.website.common.BaseException;
import com.kusitms.website.common.BaseExceptionStatus;
import com.kusitms.website.common.BaseResponse;
import com.kusitms.website.service.CorporateService;
import com.kusitms.website.service.MeetupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final MeetupService meetupService;
    private final CorporateService corporateService;

    @GetMapping()
    public ResponseEntity<BaseResponse> getProjects(@RequestParam String filter) {
        switch(filter) {
            case "meetup":
                return ResponseEntity.ok(new BaseResponse(meetupService.getMeetupProjects()));
            case "corporate":
                return ResponseEntity.ok(new BaseResponse(corporateService.getCorporateProjects()));
            default:
                throw new BaseException(BaseExceptionStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{meetup_id}")
    public ResponseEntity<BaseResponse> getMeetupProject(@PathVariable(name = "meetup_id") Long meetupId) {
        return ResponseEntity.ok(new BaseResponse(meetupService.getMeetupProject(meetupId)));
    }
}
