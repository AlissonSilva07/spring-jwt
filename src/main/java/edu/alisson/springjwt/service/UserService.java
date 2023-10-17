package edu.alisson.springjwt.service;

import edu.alisson.springjwt.model.User;
import edu.alisson.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    public void createUser(User user){
        String pass = user.getPassword();
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }
}
