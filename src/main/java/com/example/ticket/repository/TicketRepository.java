package com.example.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ticket.model.Ticket;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByEmployeeId(String employeeId);
    List<Ticket> findByStatus(String status);
}