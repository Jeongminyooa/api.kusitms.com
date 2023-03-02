package com.kusitms.website.repository;

import com.kusitms.website.domain.project.CorporateProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorporateRepository extends JpaRepository<CorporateProject, Long> {
    List<CorporateProject> findAllByOrderByCardinalDesc();
}
