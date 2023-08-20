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

    @Column(name = "DEPARTURE_AIRPORT_CODE", length = 100)
    private String departureAirportCode;

    @Column(name = "ARRIVAL_AIRPORT_CODE", length = 100)
    private String arrivalAirportCode;

    @Column(name = "DEPARTURE_DATE_TIME")
    private LocalDateTime departureDateTime;

    @Column(name = "ARRIVAL_DATE_TIME")
    private LocalDateTime arrivalDateTime;

    @Column(name = "PRICE")
    private double price;


}
