package com.enesaksoy.flightsearchapi.repository;

import com.enesaksoy.flightsearchapi.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDateTimeAndArrivalDateTime(
            String departureAirportCode, String arrivalAirportCode, LocalDateTime departureDate, LocalDateTime returnDate
    );

    List<Flight> findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDateTime(
            String departureAirportCode, String arrivalAirportCode, LocalDateTime departureDate
    );
}
