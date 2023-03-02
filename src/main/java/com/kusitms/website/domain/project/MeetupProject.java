package com.kusitms.website.domain.project;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MeetupProject {
    @Id
    @Column(name = "meetup_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetupId;

    @Column(nullable = false)
    private int cardinal;

    private String name;

    @Column(length = 400)
    private String intro;

    @Enumerated(EnumType.STRING)
    private ProjectType type;

    @Column(name = "one_line_intro", nullable = false, length = 33)
    private String oneLineIntro;

    @Column(name = "logo_url", nullable = false)
    private String logoUrl;

    @Column(name = "poster_url", nullable = false)
    private String posterUrl;

    @Column(name = "instagram_url")
    private String instagramUrl;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "app_url")
    private String appUrl;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "meetupProject", cascade = CascadeType.ALL)
    private List<MeetupTeam> team = new ArrayList<>();
}
