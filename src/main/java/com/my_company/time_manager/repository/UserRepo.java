package com.my_company.time_manager.repository;


import com.my_company.time_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public User findByLogin(String login);
    public  User getStudentById(Long id);
}