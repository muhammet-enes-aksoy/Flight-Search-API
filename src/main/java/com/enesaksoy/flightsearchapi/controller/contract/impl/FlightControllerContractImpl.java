package com.enesaksoy.flightsearchapi.controller.contract.impl;

import com.enesaksoy.flightsearchapi.controller.contract.FlightControllerContract;
import com.enesaksoy.flightsearchapi.dto.FlightDTO;
import com.enesaksoy.flightsearchapi.dto.FlightDeleteRequest;
import com.enesaksoy.flightsearchapi.dto.FlightSaveRequest;
import com.enesaksoy.flightsearchapi.dto.FlightUpdateRequest;

import com.enesaksoy.flightsearchapi.entity.Flight;
import com.enesaksoy.flightsearchapi.mapper.FlightMapper;
import com.enesaksoy.flightsearchapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlightControllerContractImpl implements FlightControllerContract {
    private final FlightService flightService;
    @Override
    public List<FlightDTO> findAll() {
        List<Flight> flightList = flightService.getAllFlights();
        return FlightMapper.INSTANCE.convertToFlightDTOList(flightList);
    }

    @Override
    public FlightDTO findById(Long id) {
        Flight flight = flightService.getFlightById(id);
        return FlightMapper.INSTANCE.convertToFlightDTO(flight);
    }

    @Override
    public void delete(FlightDeleteRequest flightDeleteRequest) {
        flightService.deleteFlight(flightDeleteRequest.getId());
    }

    @Override
    public FlightDTO update(Long id, FlightUpdateRequest flightUpdateRequest) {
        Flight flight = flightService.updateFlight(id, flightUpdateRequest);
        return FlightMapper.INSTANCE.convertToFlightDTO(flight);
    }

    @Override
    public FlightDTO save(FlightSaveRequest flightSaveRequest) {
        Flight flight = FlightMapper.INSTANCE.convertToFlight(flightSaveRequest);
        flight = flightService.createFlight(flight);
        return FlightMapper.INSTANCE.convertToFlightDTO(flight);
    }
}
