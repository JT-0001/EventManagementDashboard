package com.example.eventdashboard.dao;

import com.example.eventdashboard.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDAO extends JpaRepository<Admin, Long> {
    Admin findByUsernameAndPassword(String username, String password);
}
