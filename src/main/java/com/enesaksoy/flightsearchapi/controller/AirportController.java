package com.enesaksoy.flightsearchapi.controller;

import com.enesaksoy.flightsearchapi.RestResponse;
import com.enesaksoy.flightsearchapi.controller.contract.AirportControllerContract;
import com.enesaksoy.flightsearchapi.dto.airport.AirportDTO;
import com.enesaksoy.flightsearchapi.dto.airport.AirportDeleteRequest;
import com.enesaksoy.flightsearchapi.dto.airport.AirportSaveRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/airports")
@RequiredArgsConstructor
public class AirportController {
    private final AirportControllerContract airportControllerContract;
    @GetMapping
    public ResponseEntity<RestResponse<List<AirportDTO>>> findAll(){
        List<AirportDTO> airportDTOList = airportControllerContract.findAll();
        return  ResponseEntity.ok(RestResponse.of(airportDTOList));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<String>> delete(@RequestBody AirportDeleteRequest airportDeleteRequest){
        airportControllerContract.delete(airportDeleteRequest);
        return ResponseEntity.ok(RestResponse.of("Deleted!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<AirportDTO>> findById(@PathVariable Long id){
        AirportDTO airportDTO = airportControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(airportDTO));
    }

    @PostMapping()
    public ResponseEntity<RestResponse<AirportDTO>> save(@RequestBody AirportSaveRequest airportSaveRequest) {

        AirportDTO airportDTO = airportControllerContract.save(airportSaveRequest);
        return ResponseEntity.ok(RestResponse.of(airportDTO));
    }
}
