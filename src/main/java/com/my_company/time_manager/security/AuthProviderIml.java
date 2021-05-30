package com.my_company.time_manager.security;

import com.my_company.time_manager.model.User;
import com.my_company.time_manager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class AuthProviderIml implements AuthenticationProvider {

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
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        User user = userRepo.findByLogin(login);

        if(user == null){
            throw new UsernameNotFoundException("Student not found");
        }

        String password = authentication.getCredentials().toString();


        if(!passwordEncoder.matches(password, user.getPassword())){
            System.out.println("Password is wrong");
            throw new BadCredentialsException("Password is wrong");
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();

        return new UsernamePasswordAuthenticationToken(user, null, authorityList);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
