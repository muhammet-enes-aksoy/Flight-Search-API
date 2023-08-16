package com.enesaksoy.flightsearchapi.service;

import com.enesaksoy.flightsearchapi.entity.Airport;
import com.enesaksoy.flightsearchapi.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElseThrow();
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public void deleteAirport(Long id) {
        Airport airport = airportRepository.findById(id).orElseThrow();
        airportRepository.delete(airport);
    }
}
