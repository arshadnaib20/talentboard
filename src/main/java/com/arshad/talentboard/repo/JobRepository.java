package com.arshad.talentboard.repo;

import com.arshad.talentboard.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
