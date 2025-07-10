package com.example.eventdashboard.controller;

import com.example.eventdashboard.model.Event;
import com.example.eventdashboard.repository.EventRepository;
import com.example.eventdashboard.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:5500")
public class EventController {

    @Autowired
    private EventService eventService;

    private static final String UPLOAD_DIR = "uploads/";

    // Get events by department
    @GetMapping("/{dept}")
    public List<Event> getEvents(@PathVariable String dept) {
        return eventService.getEventsByDepartment(dept.trim());
    }

    // Get all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Add event
    @PostMapping
    public Event addEvent(
            @RequestParam("department") String department,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("date") String date,
            @RequestParam("venue") String venue,
            @RequestParam("link") String link,
            @RequestParam(value = "poster", required = false) MultipartFile poster,
            @RequestParam(value = "club", required = false) String club) throws IOException {

        String posterFilename = null;
        if (poster != null && !poster.isEmpty()) {
            posterFilename = savePosterImage(poster);
        }

        String fullPosterUrl = (posterFilename != null)
                ? "http://localhost:8080/uploads/" + posterFilename
                : null;

        // Set values manually to avoid mismatch
        Event event = new Event();
        event.setDepartment(department);
        event.setTitle(title);
        event.setDescription(description);
        event.setDate(date);
        event.setVenue(venue);
        event.setRegistrationLink(link);
        event.setPosterUrl(fullPosterUrl);
        event.setClub(club);

        return eventService.addEvent(event);
    }

    private String savePosterImage(MultipartFile poster) throws IOException {
        String originalFilename = StringUtils.cleanPath(poster.getOriginalFilename());
        Path path = Paths.get(UPLOAD_DIR + originalFilename);
        Files.createDirectories(path.getParent());
        Files.copy(poster.getInputStream(), path);
        return originalFilename;
    }

    @GetMapping("/{department}/clubs/{club}")
    public List<Event> getEventsByDepartmentAndClub(@PathVariable String department, @PathVariable String club) {
        return eventService.getEventsByDepartmentAndClub(department.trim(), club.trim());
    }

    // Delete event
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
