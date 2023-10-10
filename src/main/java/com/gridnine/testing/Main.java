package com.gridnine.testing;


public class Main {
    public static void main(String[] args) {
        FlightFilter flightFilter = new FlightFilter();
        flightFilter.addRule(new DepartureInPast());
        flightFilter.addRule(new DepartsBeforeArrives());
        flightFilter.addRule(new GroundLimitFlight());

        for (Flight flight: FlightBuilder.createFlights()) {
            if(flightFilter.makeRule(flight)) {
                System.out.println(flight);
            }
        }
    }
}
