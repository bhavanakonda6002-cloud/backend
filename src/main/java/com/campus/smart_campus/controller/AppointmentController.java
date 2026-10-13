package com.campus.smart_campus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.smart_campus.entity.Appointment;
import com.campus.smart_campus.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
    @PutMapping("/{id}")
public Appointment updateAppointment(
        @PathVariable Long id,
        @RequestBody Appointment appointment) {
    return appointmentService.updateAppointment(id, appointment);
}

@DeleteMapping("/{id}")
public String deleteAppointment(@PathVariable Long id) {
    boolean deleted = appointmentService.deleteAppointment(id);

    if (deleted) {
        return "Appointment deleted successfully";
    }

    return "Appointment not found";
}
}
