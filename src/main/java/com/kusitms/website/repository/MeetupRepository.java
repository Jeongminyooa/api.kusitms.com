package com.kusitms.website.repository;

import com.kusitms.website.domain.project.MeetupProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetupRepository extends JpaRepository<MeetupProject, Long> {
    List<MeetupProject> findAllByOrderByCardinalDesc();
}
