package com.enesaksoy.flightsearchapi.repository;

import com.enesaksoy.flightsearchapi.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {


    @Query("SELECT f FROM Flight f WHERE f.departureAirportCode = ?1 AND f.arrivalAirportCode = ?2 " +
            "AND DATE(f.departureDateTime) = ?3 AND DATE(f.arrivalDateTime) = ?4")
    List<Flight> findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDateTimeAndArrivalDateTime(
            String departureAirportCode, String arrivalAirportCode, LocalDateTime departureDate, LocalDateTime returnDate);


    @Query("SELECT f FROM Flight f WHERE f.departureAirportCode = ?1 AND f.arrivalAirportCode = ?2 " +
            "AND DATE(f.departureDateTime) = DATE(?3) ")
    List<Flight> findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDateTime(
            String departureAirportCode, String arrivalAirportCode, LocalDateTime departureDate);
}
