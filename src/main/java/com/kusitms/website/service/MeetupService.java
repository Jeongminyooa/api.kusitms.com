package com.kusitms.website.service;

import com.kusitms.website.domain.project.MeetupProject;
import com.kusitms.website.dto.MeetupResponse;
import com.kusitms.website.dto.MeetupDetailResponse;
import com.kusitms.website.repository.MeetupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetupService {
    private final MeetupRepository meetupRepository;

    private final int MAX_SIZE_INTRO = 400;
    private final int MAX_SIZE_ONE_LINE_INTRO = 33;

    @Transactional(readOnly = true)
    public MeetupResponse getMeetupProjects() {
        List<MeetupProject> findProjects = meetupRepository.findAllByOrderByCardinalDesc();

        List<MeetupDetailResponse> meetupDetailResponses = findProjects.stream()
                .map(p -> new MeetupDetailResponse(p, false))
                .collect(Collectors.toList());

        return MeetupResponse.builder()
                .meetupCount(meetupDetailResponses.size())
                .meetupList(meetupDetailResponses)
                .build();
    }

    @Transactional(readOnly = true)
    public MeetupDetailResponse getMeetupProject(Long meetupId) {
        MeetupProject findProject = meetupRepository.findById(meetupId).orElseThrow();

        return new MeetupDetailResponse(findProject, true);
    }
}
