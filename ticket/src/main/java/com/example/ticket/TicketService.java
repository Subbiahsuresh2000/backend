package com.example.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    // Create a new ticket
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Get a ticket by ID
    public Optional<Ticket> getTicketById(String ticketId) {
        return ticketRepository.findById(ticketId);
    }

    // Get all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Update an existing ticket
    public Ticket updateTicket(String ticketId, Ticket ticket) {
        if (ticketRepository.existsById(ticketId)) {
            ticket.setTicketId(ticketId);
            return ticketRepository.save(ticket);
        }
        return null;  // Return null if the ticket is not found
    }

    // Delete a ticket by ID
    public boolean deleteTicket(String ticketId) {
        if (ticketRepository.existsById(ticketId)) {
            ticketRepository.deleteById(ticketId);
            return true;
        }
        return false;
    }
}
