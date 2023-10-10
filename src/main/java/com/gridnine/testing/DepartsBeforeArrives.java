package com.gridnine.testing;

public class DepartsBeforeArrives implements FlightRule {
    @Override
    public boolean isCorrectFlight(Flight flight) {

        if(flight.getSegments().size() == 1) {
            if(flight.getSegments().get(0).getDepartureDate().isAfter(flight.getSegments().get(0).getArrivalDate())) {
                return false;
            }
        }
        else
        {
            //Проверка на дату прилета раньше даты вылета в сегменте
            for (int i = 0; i < flight.getSegments().size(); i++) {
                if(flight.getSegments().get(i).getDepartureDate().isAfter(flight.getSegments().get(i).getArrivalDate()))
                {
                    return false;
                }
            }
            //Проверка на дату прилета раньше даты вылета между прилетом текущего сегмента и вылетом следующего
            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                if(flight.getSegments().get(i).getArrivalDate().isAfter(flight.getSegments().get(i + 1).getDepartureDate())) {
                    return false;
                }
            }
        }
        return true;
    }
}
