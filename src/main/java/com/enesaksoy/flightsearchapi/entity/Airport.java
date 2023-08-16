package com.enesaksoy.flightsearchapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AIRPORT")
@Getter
@Setter
public class Airport {
    @Id
    @GeneratedValue(generator = "Airport", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Airport", sequenceName = "AIRPORT_ID_SEQ")
    private Long id;

    @Column(name = "CITY", length = 100)
    private String city;

}
