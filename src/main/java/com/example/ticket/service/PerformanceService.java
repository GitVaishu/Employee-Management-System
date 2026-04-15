package com.example.ticket.service;

import com.example.ticket.model.Status;
import com.example.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class PerformanceService {

    @Autowired
    private TicketRepository repo;

    public long ticketsResolved(String empId) {
        return repo.findByEmployeeId(empId)
                .stream()
                .filter(t -> t.getStatus() == Status.RESOLVED)
                .count();
    }

    public double avgResolutionTime(String empId) {
        return repo.findByEmployeeId(empId)
                .stream()
                .filter(t -> t.getResolvedAt() != null)
                .mapToLong(t ->
                        Duration.between(t.getCreatedAt(), t.getResolvedAt()).toHours()
                ).average().orElse(0);
    }
}