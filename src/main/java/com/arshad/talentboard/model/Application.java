package com.arshad.talentboard.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long jobId;
    private String note;
    private LocalDate appliedOn = LocalDate.now();

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    public LocalDate getAppliedOn() { return appliedOn; }
}
