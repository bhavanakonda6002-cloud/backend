package com.campus.smart_campus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.smart_campus.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
