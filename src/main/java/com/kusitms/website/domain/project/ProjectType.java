package com.kusitms.website.domain.project;

public enum ProjectType {
    APP("app"),
    WEB("web");

    private String name;

    ProjectType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
