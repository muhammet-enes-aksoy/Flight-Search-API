package com.enesaksoy.flightsearchapi.controller.contract;

import com.enesaksoy.flightsearchapi.dto.flight.*;

import java.util.List;

public interface FlightControllerContract {
    List<FlightDTO> findAll();
    FlightDTO findById(Long id);
    void delete(FlightDeleteRequest flightDeleteRequest);
    FlightDTO update(Long id, FlightUpdateRequest flightUpdateRequest);
    FlightDTO save (FlightSaveRequest flightSaveRequest);


}
