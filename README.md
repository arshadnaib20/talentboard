# TalentBoard

A full-stack job board: users register, browse jobs, and apply. Built with Java Spring Boot + a vanilla JavaScript frontend. By Arshad Naib.

## Features

- Register / login — passwords hashed with BCrypt
- Browse and search job listings
- Apply to jobs (stored in an H2 database)
- View "my applications"
- REST API: `/api/auth/register`, `/api/auth/login`, `/api/jobs`, `/api/apply`, `/api/my-applications`
- H2 file database — no install needed, data persists in `./data/`

## Run locally

Requires Java 17 and Maven.

```
mvn spring-boot:run
```

Open http://localhost:8080

## Tech stack

- Java 17
- Spring Boot 3 (Web, Data JPA, Security)
- H2 database
- HTML / CSS / vanilla JavaScript frontend

## Live demo

The frontend preview (with demo data) is hosted on GitHub Pages:
https://arshadnaib20.github.io/jobs/
