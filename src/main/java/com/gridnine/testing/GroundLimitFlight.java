package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GroundLimitFlight implements FlightRule {
    @Override
    public boolean isCorrectFlight(Flight flight) {
        if(flight.getSegments().size() > 1) {
            Double groundTime = 0d;
            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                LocalDateTime arrivalDate = flight.getSegments().get(i).getArrivalDate();
                LocalDateTime departureNextDate = flight.getSegments().get(i + 1).getDepartureDate();
                groundTime += ChronoUnit.MINUTES.between(arrivalDate, departureNextDate);
            }
            groundTime = groundTime/60;
            return groundTime <= 2;
        }
        return true;
    }
}
