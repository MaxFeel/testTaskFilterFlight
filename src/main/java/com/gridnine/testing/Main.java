package com.gridnine.testing;


public class Main {
    public static void main(String[] args) {


        DepartureInPast departureInPast = new DepartureInPast();
        DepartsBeforeArrives departsBeforeArrives = new DepartsBeforeArrives();
        GroundLimitFlight groundLimitFlight = new GroundLimitFlight();


        FlightFilterFactory.addToFilter(departureInPast);
        FlightFilterFactory.addToFilter(departsBeforeArrives);
        FlightFilterFactory.addToFilter(groundLimitFlight);


        Flight flight;

        for (int i = 0; i < FlightBuilder.createFlights().toArray().length; i++) {
            flight = new Flight(FlightBuilder.createFlights().get(i).getSegments());
            if(FlightFilterFactory.doFilter(flight))
            {
                System.out.println(flight);
            }
        }
    }
}
