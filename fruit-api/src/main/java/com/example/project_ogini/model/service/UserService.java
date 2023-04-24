package com.example.project_ogini.model.service;

import com.example.project_ogini.model.entities.User;
import com.example.project_ogini.model.entities.UserDetail;
import com.example.project_ogini.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        return new UserDetail(user);
    }

    public UserDetails loadUserById(int id) throws UsernameNotFoundException {
        User user = userRepository.getById(id);
        if (user == null)
            throw new UsernameNotFoundException(Integer.toString(id));
        return new UserDetail(user);
    }

    public User getUserById(int id) {
        return userRepository.getById(id);
    }


}
