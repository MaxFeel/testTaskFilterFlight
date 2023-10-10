package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FlightFilter {
    private final List<FlightRule> flightRule = new ArrayList<>();

    public void addRule(FlightRule flightFilter) {
        flightRule.add(flightFilter);
    }

    public boolean makeRule(Flight flight) {
        for (int i = 0; i < flightRule.size(); i++) {
           if(!flightRule.get(i).isCorrectFlight(flight)){
               return false;
           }
        }
        return true;
    }
}
