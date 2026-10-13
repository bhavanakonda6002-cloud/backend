package com.campus.smart_campus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus.smart_campus.entity.QueueEntry;
import com.campus.smart_campus.service.QueueService;

@RestController
@RequestMapping("/api/queue")
@CrossOrigin(origins = "http://localhost:5173")
public class QueueController {

    private final QueueService queueService;

    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @PostMapping
    public QueueEntry joinQueue(@RequestBody QueueEntry entry) {
        return queueService.joinQueue(entry);
    }

    @GetMapping
    public List<QueueEntry> getAllQueueEntries() {
        return queueService.getAllQueueEntries();
    }

    @PostMapping("/serve-next")
public QueueEntry serveNextStudent(
        @RequestParam String serviceName) {
    return queueService.serveNextStudent(serviceName);
}

    @PutMapping("/complete/{id}")
    public QueueEntry completeStudent(@PathVariable Long id) {
        return queueService.completeStudent(id);
    }
}