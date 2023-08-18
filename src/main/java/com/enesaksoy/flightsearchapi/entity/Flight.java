package com.enesaksoy.flightsearchapi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "FLIGHT")
public class Flight {

    @Id
    @GeneratedValue(generator = "Flight", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Flight", sequenceName = "FLIGHT_ID_SEQ")
    private Long id;

    @Column(name = "DEPARTUREAIRPORTCODE", length = 100)
    private String departureAirportCode;

    @Column(name = "ARRIVALAIRPORTCODE", length = 100)
    private String arrivalAirportCode;

    @Column(name = "DEPARTUREDATETIME")
    private LocalDateTime departureDateTime;

    @Column(name = "ARRIVALDATETIME")
    private LocalDateTime arrivalDateTime;

    @Column(name = "PRICE")
    private double price;

}
