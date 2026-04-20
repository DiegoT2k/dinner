package it.project.dinner.service;

import it.project.dinner.model.Dessert;
import it.project.dinner.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User create(User user);

    public List<User> getAll();
}

