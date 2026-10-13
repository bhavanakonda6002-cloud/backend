package com.campus.smart_campus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campus.smart_campus.entity.Appointment;
import com.campus.smart_campus.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus("BOOKED");
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
    Appointment appointment = appointmentRepository.findById(id).orElse(null);

    if (appointment == null) {
        return null;
    }

    appointment.setStudentName(updatedAppointment.getStudentName());
    appointment.setEmail(updatedAppointment.getEmail());
    appointment.setServiceName(updatedAppointment.getServiceName());
    appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
    appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());

    return appointmentRepository.save(appointment);
}

public boolean deleteAppointment(Long id) {
    if (!appointmentRepository.existsById(id)) {
        return false;
    }

    appointmentRepository.deleteById(id);
    return true;
}

}