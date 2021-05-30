package com.my_company.time_manager.service;

import com.my_company.time_manager.model.Admin;
import com.my_company.time_manager.model.User;
import com.my_company.time_manager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepo.findByLogin(login);
        if (user == null){
            throw new UsernameNotFoundException("user with this login has not found");
        }
        return user;
    }


    public List<User> showAll(){
        return userRepo.findAll();
    }

    public User save(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepo.saveAndFlush(user);
    }
}
