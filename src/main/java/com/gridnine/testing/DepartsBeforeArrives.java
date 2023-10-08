package com.gridnine.testing;

public class DepartsBeforeArrives implements FlightFilter{
    @Override
    public boolean checkFlight(Flight flight) {

        if(flight.getSegments().toArray().length == 1)
        {
            if(flight.getSegments().get(0).getDepartureDate().isAfter(flight.getSegments().get(0).getArrivalDate()))
            {
                return false;
            }
        }
        else
        {
            //Проверка на дату прилета раньше даты вылета в сегменте
            for (int i = 0; i < flight.getSegments().toArray().length; i++) {
                if(flight.getSegments().get(i).getDepartureDate().isAfter(flight.getSegments().get(i).getArrivalDate()))
                {
                    return false;
                }


            }
            //Проверка на дату прилета раньше даты вылета между прилетом текущего сегмента и вылетом следующего
            for (int i = 0; i < flight.getSegments().toArray().length - 1; i++) {
                if(flight.getSegments().get(i).getArrivalDate().isAfter(flight.getSegments().get(i + 1).getDepartureDate()))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
