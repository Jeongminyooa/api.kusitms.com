package com.kusitms.website.domain.project;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class MeetupTeam {
    @Id
    @Column(name = "team_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meetup_id")
    private MeetupProject meetupProject;

    @Enumerated(EnumType.STRING)
    private Team team;

    private String name;
}
