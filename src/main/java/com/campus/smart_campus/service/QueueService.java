package com.campus.smart_campus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campus.smart_campus.entity.QueueEntry;
import com.campus.smart_campus.repository.QueueRepository;

@Service
public class QueueService {

private final QueueRepository queueRepository;

public QueueService(QueueRepository queueRepository) {
    this.queueRepository = queueRepository;
}

public QueueEntry joinQueue(QueueEntry entry) {
    entry.setStatus("WAITING");
    return queueRepository.save(entry);
}

public List<QueueEntry> getAllQueueEntries() {
    return queueRepository.findAll();
}

public QueueEntry serveNextStudent(String serviceName) {

    boolean studentAlreadyServing =
            queueRepository.existsByServiceNameAndStatus(
                    serviceName, "SERVING");

    if (studentAlreadyServing) {
        return null;
    }

    List<QueueEntry> waitingStudents =
            queueRepository.findByServiceNameAndStatusOrderByIdAsc(
                    serviceName, "WAITING");

    if (waitingStudents.isEmpty()) {
        return null;
    }

    QueueEntry nextStudent = waitingStudents.get(0);
    nextStudent.setStatus("SERVING");

    return queueRepository.save(nextStudent);
}

public QueueEntry completeStudent(Long id) {
    QueueEntry entry = queueRepository.findById(id).orElse(null);

    if (entry == null || !"SERVING".equals(entry.getStatus())) {
        return null;
    }

    entry.setStatus("COMPLETED");
    return queueRepository.save(entry);
}

}