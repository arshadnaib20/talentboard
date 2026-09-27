package com.arshad.talentboard.model;

import jakarta.persistence.*;

@Entity
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String company;
    private String location;
    private String type;      // Remote / Hybrid / On-site
    private String level;     // Intern / Junior
    private String salary;
    @Column(length = 1000)
    private String description;
    private String skills;    // comma-separated

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    public String getSalary() { return salary; }
    public void setSalary(String salary) { this.salary = salary; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
}
