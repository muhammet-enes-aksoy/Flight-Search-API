package com.enesaksoy.flightsearchapi.service;

import com.enesaksoy.flightsearchapi.dto.flight.FlightSearchResponse;
import com.enesaksoy.flightsearchapi.dto.flight.FlightUpdateRequest;
import com.enesaksoy.flightsearchapi.entity.Flight;
import com.enesaksoy.flightsearchapi.mapper.FlightMapper;
import com.enesaksoy.flightsearchapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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

    public Flight saveFlight(Flight flight) {
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

    public List<FlightSearchResponse> searchFlights(String departureAirportCode, String arrivalAirportCode,
                                                    LocalDateTime departureDate) {
        List<Flight> flights;

        flights = flightRepository.findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDateTime(
                    departureAirportCode, arrivalAirportCode, departureDate);

        return FlightMapper.INSTANCE.convertToFlightSearchResponseList(flights);
    }

    public List<List<FlightSearchResponse>> findFlightsByDepartureAndReturnDate(
            String departureAirportCode, String arrivalAirportCode, LocalDateTime departureDate, LocalDateTime returnDate) {
        List<Flight> matchingDepartureFlights = flightRepository.findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDateTime(
                departureAirportCode, arrivalAirportCode, departureDate);

        List<Flight> matchingReturnFlights = flightRepository.findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDateTime(
                arrivalAirportCode, departureAirportCode, returnDate);

        List<List<FlightSearchResponse>> result = new ArrayList<>();

        for (Flight departureFlight : matchingDepartureFlights) {
            List<FlightSearchResponse> flightPair = new ArrayList<>();
            flightPair.add(FlightMapper.INSTANCE.convertToFlightSearchResponse(departureFlight));

            for (Flight returnFlight : matchingReturnFlights) {
                // Eğer dönüş tarihi gidiş tarihinden daha erkense bu uçuşu listeye ekleme
                if (!returnFlight.getDepartureDateTime().isBefore(departureFlight.getDepartureDateTime())) {
                    flightPair.add(FlightMapper.INSTANCE.convertToFlightSearchResponse(returnFlight));
                    result.add(new ArrayList<>(flightPair));
                    flightPair.remove(FlightMapper.INSTANCE.convertToFlightSearchResponse(returnFlight));
                }
            }
        }

        return result;
    }
}
