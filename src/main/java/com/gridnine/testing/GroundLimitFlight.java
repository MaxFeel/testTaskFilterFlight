package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GroundLimitFlight implements FlightFilter{
    @Override
    public boolean checkFlight(Flight flight) {

        LocalDateTime departureNextDate;
        LocalDateTime arrivalDateFilter;
        Long groundTime = 0L;

        if(flight.getSegments().toArray().length > 1) {
            for (int i = 0; i < flight.getSegments().toArray().length - 1; i++) {
                arrivalDateFilter = flight.getSegments().get(i).getArrivalDate();
                departureNextDate = flight.getSegments().get(i + 1).getDepartureDate();
                groundTime += ChronoUnit.MINUTES.between(arrivalDateFilter, departureNextDate);

            }
            groundTime = groundTime/60;
            return groundTime <= 2;
        }

        return true;
    }
}
