package com.example.eventdashboard.service;

import com.example.eventdashboard.dao.EventDAO;
import com.example.eventdashboard.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventDAO eventDAO;

    public List<Event> getEventsByDepartment(String dept) {
        return eventDAO.findByDepartment(dept);
    }

    public List<Event> getEventsByDepartmentAndClub(String dept, String club) {
        return eventDAO.findByDepartmentAndClub(dept, club);
    }

    public Event addEvent(Event event) {
        return eventDAO.save(event);
    }

    public List<Event> getAllEvents() {
        return eventDAO.findAll();
    }

    public void deleteEvent(Long id) {
        eventDAO.deleteById(id);
    }
}
