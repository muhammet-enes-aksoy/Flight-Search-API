package com.enesaksoy.flightsearchapi.repository;

import com.enesaksoy.flightsearchapi.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
