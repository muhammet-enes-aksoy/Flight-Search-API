package com.enesaksoy.flightsearchapi.controller;

import com.enesaksoy.flightsearchapi.RestResponse;
import com.enesaksoy.flightsearchapi.controller.contract.FlightControllerContract;
import com.enesaksoy.flightsearchapi.dto.flight.FlightDTO;
import com.enesaksoy.flightsearchapi.dto.flight.FlightDeleteRequest;
import com.enesaksoy.flightsearchapi.dto.flight.FlightSaveRequest;
import com.enesaksoy.flightsearchapi.dto.flight.FlightUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightControllerContract flightControllerContract;

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


}
