package com.enesaksoy.flightsearchapi;

import com.enesaksoy.flightsearchapi.dto.flight.FlightApiResponse;
import com.enesaksoy.flightsearchapi.dto.flight.FlightDTO;
import com.enesaksoy.flightsearchapi.entity.Airport;
import com.enesaksoy.flightsearchapi.entity.Flight;
import com.enesaksoy.flightsearchapi.repository.AirportRepository;
import com.enesaksoy.flightsearchapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@EnableScheduling
@Configuration
@Component
public class FlightDataUpdater {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    @Autowired
    public FlightDataUpdater(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?") // Schedule to run every minute
    public void updateFlightData() {
        System.out.println("Scheduled job started at: " + LocalDateTime.now());
        RestTemplate restTemplate = new RestTemplate();

        // Simulate mock API response
        FlightApiResponse response = createMockApiResponse();

        if (response != null) {
            List<FlightDTO> flightDtoList = response.getFlights();
            List<Airport> airports = airportRepository.findAll();

            List<Airport> availableAirports = new ArrayList<>(airports);

            for (FlightDTO flightDto : flightDtoList) {
                Airport randomDepartureAirport = getRandomAirport(availableAirports);
                availableAirports.remove(randomDepartureAirport);

                Airport randomArrivalAirport = getRandomAirport(availableAirports);

                Flight flight = new Flight();
                flight.setDepartureAirportCode(randomDepartureAirport.getCity());
                //flight.setArrivalAirportCode(randomArrivalAirport.getCity());

                LocalDateTime now = LocalDateTime.now();
                LocalTime randomDepartureTime = generateRandomDepartureTime();
                LocalDate randomDepartureDate = generateRandomDepartureDate(now);
                LocalDateTime randomDepartureDateTime = randomDepartureDate.atTime(randomDepartureTime);
                LocalDateTime randomArrivalDateTime = randomDepartureDateTime.plusHours(2); // Assuming 2 hours flight time
                int randomPrice = generateRandomPrice();

                flight.setDepartureDateTime(randomDepartureDateTime);
                flight.setArrivalDateTime(randomArrivalDateTime);
                flight.setPrice(randomPrice);

                flightRepository.save(flight);
            }
        }
        System.out.println("Scheduled job completed at: " + LocalDateTime.now());
    }

    private int generateRandomPrice() {
        int minPrice = 800;
        int maxPrice = 3000;
        int priceRange = maxPrice - minPrice;
        int randomRange = ThreadLocalRandom.current().nextInt(priceRange / 50 + 1);
        return minPrice + randomRange * 50;
    }

    private LocalDate generateRandomDepartureDate(LocalDateTime baseDateTime) {
        long daysToAdd = ThreadLocalRandom.current().nextLong(1, 8); // Between 1 and 7 days ahead
        return baseDateTime.toLocalDate().plusDays(daysToAdd);
    }

    private LocalTime generateRandomDepartureTime() {
        int randomHour = ThreadLocalRandom.current().nextInt(0, 24); // Between 0 and 23 hours
        int randomMinute = ThreadLocalRandom.current().nextInt(0, 4) * 15; // 15-minute intervals
        return LocalTime.of(randomHour, randomMinute);
    }

    private Airport getRandomAirport(List<Airport> airports) {
        if (airports.isEmpty()) {
            return null;
        }

        int randomIndex = ThreadLocalRandom.current().nextInt(airports.size());
        return airports.get(randomIndex);
    }

    private FlightApiResponse createMockApiResponse() {
        FlightApiResponse response = new FlightApiResponse();
        List<FlightDTO> flightDtoList = new ArrayList<>();

        // Simulated mock flight data for testing purposes
        FlightDTO flightDto1 = new FlightDTO();
        flightDto1.setDepartureAirportCode("ABC");
        flightDto1.setArrivalAirportCode("XYZ");
        // Set other properties

        FlightDTO flightDto2 = new FlightDTO();
        flightDto2.setDepartureAirportCode("DEF");
        flightDto2.setArrivalAirportCode("GHI");
        // Set other properties

        // Add simulated flight data to the list
        flightDtoList.add(flightDto1);
        flightDtoList.add(flightDto2);

        response.setFlights(flightDtoList);
        return response;
    }
}
