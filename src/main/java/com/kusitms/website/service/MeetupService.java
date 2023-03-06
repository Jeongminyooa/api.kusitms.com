package com.kusitms.website.service;

import com.kusitms.website.domain.project.MeetupProject;
import com.kusitms.website.dto.meetup.MeetupRequest;
import com.kusitms.website.dto.meetup.MeetupResponse;
import com.kusitms.website.dto.meetup.MeetupDetailResponse;
import com.kusitms.website.dto.meetup.MeetupTeamRequest;
import com.kusitms.website.repository.MeetupRepository;
import com.kusitms.website.repository.MeetupTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetupService {
    private final S3Service s3Service;
    private final MeetupRepository meetupRepository;
    private final MeetupTeamRepository meetupTeamRepository;

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

    @Transactional
    public void save(MeetupRequest req, MultipartFile logoFile, MultipartFile posterFile) throws IOException {
        String logoUrl = s3Service.uploadFile(logoFile, "meetup");
        String posterUrl = s3Service.uploadFile(posterFile, "meetup");

        MeetupProject meetup = req.toEntity(logoUrl, posterUrl);

        meetupRepository.save(meetup);

        for(MeetupTeamRequest t : req.getMeetupTeamRequests()) {
            meetupTeamRepository.save(t.toEntity(meetup));
        }
    }

}
