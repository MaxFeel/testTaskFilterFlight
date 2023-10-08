package com.gridnine.testing;

import java.time.LocalDateTime;

public class DepartureInPast implements FlightFilter{
    @Override
    public boolean checkFlight(Flight flight) {

        for (int i = 0; i < flight.getSegments().toArray().length; i++) {
            if(flight.getSegments().get(i).getDepartureDate().isBefore(LocalDateTime.now()))
            {
                return false;
            }
        }

        return true;
    }
}
