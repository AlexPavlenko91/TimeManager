package com.my_company.time_manager.service;

import com.my_company.time_manager.model.Admin;
import com.my_company.time_manager.model.User;
import com.my_company.time_manager.repository.AdminRepo;
import com.my_company.time_manager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements UserDetailsService {

    private AdminRepo adminRepo;
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setAdminRepo(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Admin admin = adminRepo.findByLogin(login);
        if (admin == null){
            throw new UsernameNotFoundException("admin with this login has not found");
        }
        return admin;
    }


    public List<User> showAllUsers(){
        return userRepo.findAll();
    }

    public Admin save(Admin admin) {

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        return adminRepo.saveAndFlush(admin);
    }

}
