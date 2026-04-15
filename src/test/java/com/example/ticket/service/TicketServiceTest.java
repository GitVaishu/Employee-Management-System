package com.example.ticket.service;

import com.example.ticket.model.Ticket;
import com.example.ticket.model.Status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TicketServiceTest {

    @Autowired
    private TicketService service;

    @Test
    void testCreateTicket() {
        Ticket t = new Ticket();
        t.setTitle("Test Ticket");
        t.setEmployeeId("E101");

        Ticket saved = service.createTicket(t);

        assertNotNull(saved.getId());
        assertEquals(Status.OPEN, saved.getStatus());
    }
}