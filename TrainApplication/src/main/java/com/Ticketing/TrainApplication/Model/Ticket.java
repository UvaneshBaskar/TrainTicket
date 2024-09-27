package com.Ticketing.TrainApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String departure;
    private String arrival;
    private String userName;
    private String email;
    private String section;
    private int seatNumber;
    private double pricePaid;

    public Ticket() {
        this.pricePaid = 20.0; // Fixed price
    }
}

