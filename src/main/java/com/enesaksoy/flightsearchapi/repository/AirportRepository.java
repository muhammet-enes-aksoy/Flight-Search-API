package com.enesaksoy.flightsearchapi.repository;

import com.enesaksoy.flightsearchapi.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
