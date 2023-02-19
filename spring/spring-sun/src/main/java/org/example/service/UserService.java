package org.example.service;

import org.example.model.User;

public interface UserService {
    public void register(User user);

    public boolean login(User user);
}
