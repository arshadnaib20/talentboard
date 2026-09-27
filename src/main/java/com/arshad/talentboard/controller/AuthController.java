package com.arshad.talentboard.controller;

import com.arshad.talentboard.model.User;
import com.arshad.talentboard.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository users;
    private final PasswordEncoder encoder;

    public AuthController(UserRepository users, PasswordEncoder encoder) {
        this.users = users;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        if (users.findByEmail(email).isPresent()) {
            return Map.of("ok", false, "error", "Email already registered");
        }
        User u = new User();
        u.setFullName(body.get("name"));
        u.setEmail(email);
        u.setPasswordHash(encoder.encode(body.get("password")));
        users.save(u);
        return Map.of("ok", true, "userId", u.getId(), "name", u.getFullName());
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        return users.findByEmail(body.get("email"))
            .filter(u -> encoder.matches(body.get("password"), u.getPasswordHash()))
            .<Map<String, Object>>map(u -> Map.of("ok", true, "userId", u.getId(), "name", u.getFullName()))
            .orElse(Map.of("ok", false, "error", "Wrong email or password"));
    }
}
