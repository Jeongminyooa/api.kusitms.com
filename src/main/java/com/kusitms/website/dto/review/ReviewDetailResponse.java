package com.kusitms.website.dto.review;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kusitms.website.domain.project.Team;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema
public class ReviewDetailResponse {
    @JsonProperty("review_id")
    @Schema(description = "리뷰 아이디")
    private Long reviewId;

    @Schema(description = "이름")
    private String name;

    @Schema(description = "소속팀")
    private String team;

    @Schema(description = "리뷰 내용")
    private String review;

    public ReviewDetailResponse(Long reviewId, String name, Team team, String review) {
        this.reviewId = reviewId;
        this.name = name;
        this.team = getTeamString(team);
        this.review = review;
    }

    private String getTeamString(Team team) {
        switch(team) {
            case PLANNER:
                return "기획팀";
            case DESIGNER:
                return "디자인팀";
            case DEVELOPER:
                return "개발팀";
            default:
                return null;
        }
    }
}
