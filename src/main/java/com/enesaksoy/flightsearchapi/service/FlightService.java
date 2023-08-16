package com.enesaksoy.flightsearchapi.service;

import com.enesaksoy.flightsearchapi.dto.FlightUpdateRequest;
import com.enesaksoy.flightsearchapi.entity.Flight;
import com.enesaksoy.flightsearchapi.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow();
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, FlightUpdateRequest flightUpdateRequest) {
        Flight existingFlight = flightRepository.findById(id).orElseThrow();
        
        existingFlight.setDepartureAirportCode(flightUpdateRequest.getDepartureAirportCode());
        existingFlight.setArrivalAirportCode(flightUpdateRequest.getArrivalAirportCode());
        existingFlight.setPrice(flightUpdateRequest.getPrice());
        existingFlight.setArrivalDateTime(flightUpdateRequest.getArrivalDateTime());
        existingFlight.setDepartureDateTime(flightUpdateRequest.getDepartureDateTime());


        return flightRepository.save(existingFlight);
    }

    public void deleteFlight(Long id) {
        Flight existingFlight = flightRepository.findById(id).orElseThrow();

        flightRepository.delete(existingFlight);
    }

   /* public List<Flight> searchOneWayFlights(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime) {
        return flightRepository.findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDateTime(
                departureAirport, arrivalAirport, departureDateTime
        );
    }

    public List<Flight> searchRoundTripFlights(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        return flightRepository.findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDateTimeAndArrivalDateTime(
                departureAirport, arrivalAirport, departureDateTime, arrivalDateTime
        );
    }*/
}
