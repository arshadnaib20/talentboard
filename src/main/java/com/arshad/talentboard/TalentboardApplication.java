package com.arshad.talentboard;

import com.arshad.talentboard.model.Job;
import com.arshad.talentboard.repo.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TalentboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalentboardApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(JobRepository repo) {
        return args -> {
            if (repo.count() > 0) return;
            String[][] rows = {
                {"Junior Web Developer","TechNova Solutions","Shanghai, China","On-site","Junior","¥12–18k / mo","Build customer-facing web pages with HTML, CSS and JavaScript.","html,css,javascript"},
                {"Python Backend Intern","DataStream","Beijing, China","Hybrid","Intern","¥200 / day","Write APIs and automation scripts with Python and Flask.","python,flask,sql"},
                {"Frontend Developer","Creative Studio","Remote","Remote","Junior","$800–1,400 / mo","Turn designs into fast, accessible websites.","html,css,javascript,react"},
                {"Software Engineer, Entry","CloudBase","Shenzhen, China","On-site","Junior","¥15–22k / mo","Generalist engineering role — backend, tooling, internal services.","python,java,sql,git"},
                {"Data Analyst Intern","MarketLens","Remote","Remote","Intern","¥150 / day","Turn raw spreadsheets into clear reports.","python,sql,excel"},
                {"JavaScript Developer","AppWorks","Hangzhou, China","Hybrid","Junior","¥13–19k / mo","Build interactive features for a SaaS product.","javascript,css,rest"},
            };
            for (String[] r : rows) {
                Job j = new Job();
                j.setTitle(r[0]); j.setCompany(r[1]); j.setLocation(r[2]);
                j.setType(r[3]); j.setLevel(r[4]); j.setSalary(r[5]);
                j.setDescription(r[6]); j.setSkills(r[7]);
                repo.save(j);
            }
        };
    }
}
