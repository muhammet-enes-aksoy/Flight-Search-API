package com.enesaksoy.flightsearchapi.mapper;

import com.enesaksoy.flightsearchapi.dto.airport.AirportDTO;
import com.enesaksoy.flightsearchapi.dto.airport.AirportSaveRequest;
import com.enesaksoy.flightsearchapi.entity.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirportMapper {
    AirportMapper INSTANCE = Mappers.getMapper(AirportMapper.class);
    AirportDTO convertToAirportDTO(Airport airport);
    Airport convertToAirport(AirportSaveRequest airportSaveRequest);
    List<AirportDTO> convertToAirportDTOList(List<Airport> airportList);
}
