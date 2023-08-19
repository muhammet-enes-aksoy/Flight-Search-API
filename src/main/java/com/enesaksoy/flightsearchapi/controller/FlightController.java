package com.enesaksoy.flightsearchapi.controller;

import com.enesaksoy.flightsearchapi.RestResponse;
import com.enesaksoy.flightsearchapi.controller.contract.FlightControllerContract;
import com.enesaksoy.flightsearchapi.dto.flight.*;
import com.enesaksoy.flightsearchapi.entity.Flight;
import com.enesaksoy.flightsearchapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightControllerContract flightControllerContract;
    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<RestResponse<List<FlightDTO>>> findAll(){
        List<FlightDTO> flightDTOList = flightControllerContract.findAll();
        return  ResponseEntity.ok(RestResponse.of(flightDTOList));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<String>> delete(@RequestBody FlightDeleteRequest flightDeleteRequest){
        flightControllerContract.delete(flightDeleteRequest);
        return ResponseEntity.ok(RestResponse.of("Deleted!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<FlightDTO>> findById(@PathVariable Long id){
        FlightDTO flightDTO = flightControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(flightDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<FlightDTO>> update(@PathVariable Long id, @RequestBody FlightUpdateRequest flightUpdateRequest){
        FlightDTO flightDTO = flightControllerContract.update(id, flightUpdateRequest);
        return ResponseEntity.ok(RestResponse.of(flightDTO));
    }
    @PostMapping()
    public ResponseEntity<RestResponse<FlightDTO>> save(@RequestBody FlightSaveRequest flightSaveRequest) {

        FlightDTO flightDTO = flightControllerContract.save(flightSaveRequest);
        return ResponseEntity.ok(RestResponse.of(flightDTO));
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/search")
    public List<List<Flight>> searchFlights(@RequestParam String departureAirportCode,
                                            @RequestParam String arrivalAirportCode,
                                            @RequestParam LocalDate departureDate,
                                            @RequestParam(required = false) LocalDate returnDate) {

        LocalDateTime departureDateTime = departureDate.atStartOfDay();
        LocalDateTime returnDateTime = null;
        if(returnDate != null){
            returnDateTime = returnDate.atStartOfDay();
            return flightService.findFlightsByDepartureAndReturnDate(departureAirportCode, arrivalAirportCode, departureDateTime, returnDateTime);
        }
        else{
            return Collections.singletonList(flightService.searchFlights(departureAirportCode, arrivalAirportCode, departureDateTime, returnDateTime));
        }

    }

}
