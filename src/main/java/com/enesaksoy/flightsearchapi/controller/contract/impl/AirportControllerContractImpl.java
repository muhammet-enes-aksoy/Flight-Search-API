package com.enesaksoy.flightsearchapi.controller.contract.impl;

import com.enesaksoy.flightsearchapi.controller.contract.AirportControllerContract;
import com.enesaksoy.flightsearchapi.dto.airport.AirportDTO;
import com.enesaksoy.flightsearchapi.dto.airport.AirportDeleteRequest;
import com.enesaksoy.flightsearchapi.dto.airport.AirportSaveRequest;
import com.enesaksoy.flightsearchapi.entity.Airport;
import com.enesaksoy.flightsearchapi.mapper.AirportMapper;
import com.enesaksoy.flightsearchapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AirportControllerContractImpl implements AirportControllerContract {

    private final AirportService airportService;

    @Override
    public List<AirportDTO> findAll() {
        List<Airport> airportList = airportService.getAllAirports();
        return AirportMapper.INSTANCE.convertToAirportDTOList(airportList);
    }

    @Override
    public AirportDTO findById(Long id) {
        Airport airport = airportService.getAirportById(id);
        return AirportMapper.INSTANCE.convertToAirportDTO(airport);
    }

    @Override
    public void delete(AirportDeleteRequest airportDeleteRequest) {
        airportService.deleteAirport(airportDeleteRequest.getId());

    }

    @Override
    public AirportDTO save(AirportSaveRequest airportSaveRequest) {
        Airport airport = AirportMapper.INSTANCE.convertToAirport(airportSaveRequest);
        airport = airportService.saveAirport(airport);
        return AirportMapper.INSTANCE.convertToAirportDTO(airport);
    }
}
