package com.kusitms.website.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kusitms.website.domain.project.MeetupProject;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MeetupDetailResponse {
    @JsonProperty("meetup_id")
    private Long meetupId;
    private int cardinal;
    private String name;
    private String intro;
    private String type;
    @JsonProperty("one_line_intro")
    private String oneLineIntro;

    @JsonProperty("logo_url")
    private String logoUrl;
    @JsonProperty("poster_url")
    private String posterUrl;
    @JsonProperty("instagram_url")
    private String instagramUrl;
    @JsonProperty("github_url")
    private String githubUrl;
    @JsonProperty("app_url")
    private String appUrl;

    @JsonProperty("start_date")
    private LocalDate startDate;
    @JsonProperty("end_date")
    private LocalDate endDate;

    private MeetupTeamResponse team;

    public MeetupDetailResponse(MeetupProject meetup, boolean isDetail) {
        this.meetupId = meetup.getMeetupId();
        this.cardinal = meetup.getCardinal();
        this.name = meetup.getName();
        this.posterUrl = meetup.getPosterUrl();
        this.logoUrl = meetup.getLogoUrl();
        this.oneLineIntro = meetup.getOneLineIntro();
        this.instagramUrl = meetup.getInstagramUrl();
        this.githubUrl = meetup.getGithubUrl();
        this.appUrl = meetup.getAppUrl();

        if(isDetail) {
            this.type = meetup.getType().getName();
            this.intro = meetup.getIntro();
            this.startDate = meetup.getStartDate();
            this.endDate = meetup.getEndDate();
            this.team = new MeetupTeamResponse(meetup.getTeam());
        }
    }
}
