package com.Ticketing.TrainApplication.Service;

import com.Ticketing.TrainApplication.Model.Ticket;
import com.Ticketing.TrainApplication.Repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepo ticketRepository;

    public Ticket buyTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketInfo(String email) {
        return ticketRepository.findByEmail(email);
    }
    public List<Ticket> getTicketsBySection(String section) {
        return ticketRepository.findBySection(section);
    }

    public void removeUser(String email) {
        Ticket ticket = ticketRepository.findByEmail(email);
        if (ticket != null) {
            ticketRepository.delete(ticket);
        }
    }

    public Ticket modifySeat(String email, int newSeatNumber) {
        Ticket ticket = ticketRepository.findByEmail(email);
        if (ticket != null) {
            ticket.setSeatNumber(newSeatNumber);
            return ticketRepository.save(ticket);
        }
        return null;
    }
}
