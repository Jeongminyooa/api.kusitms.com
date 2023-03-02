package com.kusitms.website.dto;

import com.kusitms.website.domain.project.MeetupTeam;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
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
