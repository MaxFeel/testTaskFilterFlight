package com.gridnine.testing;

import java.time.LocalDateTime;

public class DepartureInPast implements FlightRule {
    @Override
    public boolean isCorrectFlight(Flight flight) {
        for (int i = 0; i < flight.getSegments().size(); i++) {
            if(flight.getSegments().get(i).getDepartureDate().isBefore(LocalDateTime.now())) {
                return false;
            }
        }
        return true;
    }
}
