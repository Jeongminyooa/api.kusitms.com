package com.kusitms.website.dto.meetup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kusitms.website.domain.project.MeetupProject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDate;

import static com.kusitms.website.util.S3Util.s3Url;

@Getter
@Schema
public class MeetupDetailResponse {
    @JsonProperty("meetup_id")
    @Schema(description = "밋업 ID")
    private Long meetupId;
    @Schema(description = "프로젝트 진행 기수")
    private int cardinal;
    @Schema(description = "프로젝트 이름")
    private String name;
    @Schema(description = "프로젝트 소개")
    private String intro;
    @Schema(description = "프로젝트 구현 유형")
    private String type;
    @JsonProperty("one_line_intro")
    @Schema(description = "프로젝트 한 줄 소개")
    private String oneLineIntro;

    @JsonProperty("logo_url")
    @Schema(description = "로고 이미지 URL")
    private String logoUrl;
    @JsonProperty("poster_url")
    @Schema(description = "아이템 포스터 이미지 URL")
    private String posterUrl;
    @JsonProperty("instagram_url")
    @Schema(description = "인스타그램 URL")
    private String instagramUrl;
    @JsonProperty("github_url")
    @Schema(description = "깃허브 URL")
    private String githubUrl;
    @JsonProperty("app_url")
    @Schema(description = "프로젝트 결과물 URL")
    private String appUrl;

    @JsonProperty("start_date")
    @Schema(description = "프로젝트 시작 날짜")
    private LocalDate startDate;
    @JsonProperty("end_date")
    @Schema(description = "프로젝트 종료 날짜")
    private LocalDate endDate;

    @Schema(description = "프로젝트 참여 팀원")
    private MeetupTeamResponse team;

    public MeetupDetailResponse(MeetupProject meetup, boolean isDetail) {
        this.meetupId = meetup.getMeetupId();
        this.cardinal = meetup.getCardinal();
        this.name = meetup.getName();
        this.posterUrl = s3Url + meetup.getPosterUrl();
        this.logoUrl = s3Url + meetup.getLogoUrl();
        this.oneLineIntro = meetup.getOneLineIntro();
        this.instagramUrl = meetup.getInstagramUrl();
        this.githubUrl = meetup.getGithubUrl();
        this.appUrl = meetup.getAppUrl();

        if(isDetail) {
            this.type = meetup.getType().getName();
            this.intro = meetup.getIntro();
            this.startDate = meetup.getStartDate();
            this.endDate = meetup.getEndDate();
            this.team = new MeetupTeamResponse(meetup.getTeam(), meetup.getTeamName());
        }
    }
}
