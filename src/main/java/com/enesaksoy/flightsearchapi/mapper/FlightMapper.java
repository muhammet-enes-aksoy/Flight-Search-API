package com.enesaksoy.flightsearchapi.mapper;

import com.enesaksoy.flightsearchapi.dto.flight.FlightDTO;
import com.enesaksoy.flightsearchapi.dto.flight.FlightSaveRequest;
import com.enesaksoy.flightsearchapi.dto.flight.FlightSearchResponse;
import com.enesaksoy.flightsearchapi.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);
    FlightDTO convertToFlightDTO(Flight flight);
    Flight convertToFlight(FlightSaveRequest flightSaveRequest);
    List<FlightDTO> convertToFlightDTOList(List<Flight> flightList);

    FlightSearchResponse convertToFlightSearchResponse(Flight flight);
    default List<FlightSearchResponse> convertToFlightSearchResponseList(List<Flight> flightList) {
        return flightList.stream()
                .map(this::convertToFlightSearchResponse)
                .collect(Collectors.toList());
    }
}
