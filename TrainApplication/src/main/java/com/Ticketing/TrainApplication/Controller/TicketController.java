package com.Ticketing.TrainApplication.Controller;


import com.Ticketing.TrainApplication.Model.Ticket;
import com.Ticketing.TrainApplication.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ts;

    @PostMapping("/purchase")
    public ResponseEntity<Ticket> buyTicket(@RequestBody Ticket ticket) {
        Ticket newTicket = ts.buyTicket(ticket);
        return ResponseEntity.ok(newTicket);
    }
    @GetMapping("/receipt")
    public ResponseEntity<Ticket> getTicketInfo(@RequestParam String email) {
        Ticket ticket = ts.getTicketInfo(email);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/section/{section}")
    public ResponseEntity<List<Ticket>> getUsersBySection(@PathVariable String section) {
        List<Ticket> tickets = ts.getTicketsBySection(section);
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> deleteUser(@RequestParam String email) {
        ts.removeUser(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/modify")
    public ResponseEntity<Ticket> modifySeat(@RequestParam String email, @RequestParam int seatNumber) {
        Ticket updatedTicket = ts.modifySeat(email, seatNumber);
        return ResponseEntity.ok(updatedTicket);
    }
}

