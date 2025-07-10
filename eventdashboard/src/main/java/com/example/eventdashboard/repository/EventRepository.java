package com.example.eventdashboard.repository;

import com.example.eventdashboard.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Correct method signature for finding events by department and club
    List<Event> findByDepartmentAndClub(String department, String club);
    
}
