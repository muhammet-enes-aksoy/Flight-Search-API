package com.enesaksoy.flightsearchapi.controller.contract;

import com.enesaksoy.flightsearchapi.dto.airport.AirportDTO;
import com.enesaksoy.flightsearchapi.dto.airport.AirportDeleteRequest;
import com.enesaksoy.flightsearchapi.dto.airport.AirportSaveRequest;

import java.util.List;

public interface AirportControllerContract {
    List<AirportDTO> findAll();
    AirportDTO findById(Long id);
    void delete(AirportDeleteRequest airportDeleteRequest);
    AirportDTO save (AirportSaveRequest airportSaveRequest);

}
