package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FlightFilterFactory {

    private static List<FlightFilter> flightFilters = new ArrayList<>();

    static void addToFilter(FlightFilter flightFilter){
        flightFilters.add(flightFilter);
    }

    static boolean doFilter(Flight flight){
        for (int i = 0; i < flightFilters.toArray().length; i++) {
           if(!flightFilters.get(i).checkFlight(flight)){
               return false;
           }
        }
        return true;
    }
}
