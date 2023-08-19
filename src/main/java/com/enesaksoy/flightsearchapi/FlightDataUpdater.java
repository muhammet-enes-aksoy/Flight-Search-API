package com.enesaksoy.flightsearchapi;

import com.enesaksoy.flightsearchapi.dto.flight.FlightApiResponse;
import com.enesaksoy.flightsearchapi.dto.flight.FlightDTO;
import com.enesaksoy.flightsearchapi.entity.Flight;
import com.enesaksoy.flightsearchapi.repository.FlightRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Component
public class FlightDataUpdater {

    private final String MOCK_API_URL = "https://mock-api.com/flights"; // Mock API URL
    private final FlightRepository flightRepository; // Assume FlightRepository is your repository for flights
    private static final Logger logger = LoggerFactory.getLogger(FlightDataUpdater.class);
    @Autowired
    public FlightDataUpdater(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?") // Schedule to run every day at midnight
    public void updateFlightData() {
        logger.info("Scheduled job started at: " + LocalDateTime.now());
        RestTemplate restTemplate = new RestTemplate();
        FlightApiResponse response = restTemplate.getForObject(MOCK_API_URL, FlightApiResponse.class);

        if (response != null) {
            for (FlightDTO flightDto : response.getFlights()) {
                Flight flight = new Flight();
                flight.setDepartureAirportCode(flightDto.getDepartureAirportCode());
                flight.setArrivalAirportCode(flightDto.getArrivalAirportCode());
                flight.setDepartureDateTime(flightDto.getDepartureDateTime());
                flight.setArrivalDateTime(flightDto.getArrivalDateTime());
                flight.setPrice(flightDto.getPrice());

                flightRepository.save(flight);
            }
        }
        logger.info("Scheduled job completed at: " + LocalDateTime.now());
    }
}
