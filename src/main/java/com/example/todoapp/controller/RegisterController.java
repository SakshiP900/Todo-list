package com.example.todoapp.controller;

import com.example.todoapp.model.User;
import com.example.todoapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository,
                              PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Show registration form
    @GetMapping
    public String showRegistrationForm() {
        return "register";  // corresponds to register.html in templates/
    }

    // Handle registration form submission
    @PostMapping
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        if (userRepository.existsById(username)) {
            model.addAttribute("error", "User already exists");
            return "register";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        model.addAttribute("success", "User registered successfully. You can now log in.");
        return "login";  // redirect to login page after registration
    }
}
