package com.Ticketing.TrainApplication.Repo;


import com.Ticketing.TrainApplication.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
    List<Ticket> findBySection(String section);
    Ticket findByEmail(String email);
}

