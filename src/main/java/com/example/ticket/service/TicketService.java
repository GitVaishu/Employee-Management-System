package com.example.ticket.service;

import com.example.ticket.model.Status;
import com.example.ticket.model.Ticket;

import com.example.ticket.repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TicketService {

    @Autowired
    private TicketRepository repo;

    public Ticket createTicket(Ticket ticket) {
        ticket.setStatus(Status.OPEN);
        return repo.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return repo.findAll();
    }

    public Ticket updateStatus(Long id, Status status) {
        Ticket t = repo.findById(id).orElseThrow();
        t.setStatus(status);

        if (status == Status.RESOLVED) {
            t.setResolvedAt(LocalDateTime.now());
        }

        return repo.save(t);
    }

    public Ticket reassign(Long id, String newEmpId) {
        Ticket t = repo.findById(id).orElseThrow();
        t.setEmployeeId(newEmpId);
        return repo.save(t);
    }
}