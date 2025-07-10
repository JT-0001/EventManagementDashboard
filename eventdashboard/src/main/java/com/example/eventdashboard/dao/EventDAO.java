package com.example.eventdashboard.dao;

import com.example.eventdashboard.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventDAO extends JpaRepository<Event, Long> {
    List<Event> findByDepartment(String department);
    List<Event> findByDepartmentAndClub(String department, String club); // ✅ Add this
}
