package com.kusitms.website.domain.review;

import com.kusitms.website.domain.project.Team;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @Column(name = "review_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Team team;

    @Column(nullable = false, length = 300)
    private String review;
}
