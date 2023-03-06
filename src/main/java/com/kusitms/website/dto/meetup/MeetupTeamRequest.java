package com.kusitms.website.dto.meetup;

import com.amazonaws.util.StringUtils;
import com.kusitms.website.domain.project.MeetupProject;
import com.kusitms.website.domain.project.MeetupTeam;
import com.kusitms.website.domain.project.Team;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class MeetupTeamRequest {
    @Schema(description = "팀")
    private String team;
    @Schema(description = "이름")
    private String name;

    public MeetupTeam toEntity(MeetupProject meetup) {
        return MeetupTeam.builder()
                .meetup(meetup)
                .team(Team.valueOf(StringUtils.upperCase(team)))
                .name(name)
                .build();
    }
}
