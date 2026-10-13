package com.campus.smart_campus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.smart_campus.entity.QueueEntry;

public interface QueueRepository extends JpaRepository<QueueEntry, Long> {

    List<QueueEntry> findByStatusOrderByIdAsc(String status);
    List<QueueEntry> findByServiceNameAndStatusOrderByIdAsc(
        String serviceName, String status);

boolean existsByServiceNameAndStatus(
        String serviceName, String status);
}
