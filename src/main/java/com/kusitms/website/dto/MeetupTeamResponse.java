package com.kusitms.website.dto;

import com.kusitms.website.domain.project.MeetupTeam;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MeetupTeamResponse {
    private List<String> planner;
    private List<String> designer;
    private List<String> frontend;
    private List<String> backend;
    private List<String> ios;
    private List<String> android;

    public MeetupTeamResponse(List<MeetupTeam> team) {
        planner = new ArrayList<>();
        designer = new ArrayList<>();
        frontend = new ArrayList<>();
        backend = new ArrayList<>();
        ios = new ArrayList<>();
        android = new ArrayList<>();

        for(MeetupTeam t : team) {
            switch(t.getTeam()) {
                case PLANNER:
                    planner.add(t.getName());
                    break;
                case DESIGNER:
                    designer.add(t.getName());
                    break;
                case FRONTEND:
                    frontend.add(t.getName());
                    break;
                case BACKEND:
                    backend.add(t.getName());
                    break;
                case IOS:
                    ios.add(t.getName());
                    break;
                case ANDROID:
                    android.add(t.getName());
                    break;
            }
        }
    }
}
