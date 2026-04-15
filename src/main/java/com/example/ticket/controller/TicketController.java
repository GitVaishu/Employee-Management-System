package com.example.ticket.controller;

import com.example.ticket.model.Ticket;
import com.example.ticket.model.Status;
import com.example.ticket.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return service.createTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getAll() {
        return service.getAllTickets();
    }

    @PutMapping("/{id}/status")
    public Ticket updateStatus(@PathVariable Long id, @RequestParam Status status) {
        return service.updateStatus(id, status);
    }

    @PutMapping("/{id}/reassign")
    public Ticket reassign(@PathVariable Long id, @RequestParam String empId) {
        return service.reassign(id, empId);
    }
}