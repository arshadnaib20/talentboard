package com.arshad.talentboard.controller;

import com.arshad.talentboard.model.Application;
import com.arshad.talentboard.model.Job;
import com.arshad.talentboard.repo.ApplicationRepository;
import com.arshad.talentboard.repo.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class JobController {

    private final JobRepository jobs;
    private final ApplicationRepository applications;

    public JobController(JobRepository jobs, ApplicationRepository applications) {
        this.jobs = jobs;
        this.applications = applications;
    }

    @GetMapping("/jobs")
    public List<Job> list() { return jobs.findAll(); }

    @PostMapping("/apply")
    public Map<String, Object> apply(@RequestBody Map<String, Object> body) {
        Application a = new Application();
        a.setUserId(Long.valueOf(body.get("userId").toString()));
        a.setJobId(Long.valueOf(body.get("jobId").toString()));
        a.setNote((String) body.get("note"));
        applications.save(a);
        return Map.of("ok", true);
    }

    @GetMapping("/my-applications")
    public List<Application> mine(@RequestParam Long userId) {
        return applications.findByUserId(userId);
    }
}
