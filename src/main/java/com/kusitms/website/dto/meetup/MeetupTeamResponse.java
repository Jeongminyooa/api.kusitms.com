package com.kusitms.website.dto.meetup;

import com.kusitms.website.domain.project.MeetupTeam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class MeetupTeamResponse {
    @Schema(description = "기획자 팀원")
    private List<String> planner;
    @Schema(description = "디자이너 팀원")
    private List<String> designer;
    @Schema(description = "프론트엔드 팀원")
    private List<String> frontend;
    @Schema(description = "백엔드 팀원")
    private List<String> backend;
    @Schema(description = "IOS 팀원")
    private List<String> ios;
    @Schema(description = "ANDROID 팀원")
    private List<String> android;

    public MeetupTeamResponse(List<MeetupTeam> team) {
        for(MeetupTeam t : team) {
            switch(t.getTeam()) {
                case PLANNER:
                    if(planner == null) {
                        planner = new ArrayList<>();
                    }
                    planner.add(t.getName());
                    break;
                case DESIGNER:
                    if(designer == null) {
                        designer = new ArrayList<>();
                    }
                    designer.add(t.getName());
                    break;
                case FRONTEND:
                    if(frontend == null) {
                        frontend = new ArrayList<>();
                    }
                    frontend.add(t.getName());
                    break;
                case BACKEND:
                    if(backend == null) {
                        backend = new ArrayList<>();
                    }
                    backend.add(t.getName());
                    break;
                case IOS:
                    if(ios == null) {
                        ios = new ArrayList<>();
                    }
                    ios.add(t.getName());
                    break;
                case ANDROID:
                    if(android == null) {
                        android = new ArrayList<>();
                    }
                    android.add(t.getName());
                    break;
            }
        }

        Collections.sort(planner);
        Collections.sort(designer);
        Collections.sort(backend);
        if(frontend != null) {
            Collections.sort(frontend);
        }
        if(ios != null) {
            Collections.sort(ios);
        }
        if(android != null) {
            Collections.sort(android);
        }
    }
}
