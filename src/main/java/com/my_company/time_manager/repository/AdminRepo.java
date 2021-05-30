package com.my_company.time_manager.repository;


import com.my_company.time_manager.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    public Admin findByLogin(String login);
    public  Admin getAdminById(Long id);
}