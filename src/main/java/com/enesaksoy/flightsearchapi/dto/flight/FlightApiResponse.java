package com.enesaksoy.flightsearchapi.dto.flight;

import java.util.List;

public class FlightApiResponse {
    private List<FlightDTO> flights;

    public List<FlightDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDTO> flights) {
        this.flights = flights;
    }
}

