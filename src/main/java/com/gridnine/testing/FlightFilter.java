package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public interface FlightFilter {

    boolean checkFlight(Flight flight);
}
