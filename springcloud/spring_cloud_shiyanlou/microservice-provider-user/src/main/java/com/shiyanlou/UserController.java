package com.shiyanlou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return this.userRepository.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);


    }

}
