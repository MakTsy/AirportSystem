package labs.second.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import labs.second.entities.dto.FlightDTO;
import labs.second.entities.Flight;
import labs.second.services.FlightControllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flights")
public class FlightControlController {
    private final FlightControllService flightControllService;

    @Autowired
    public FlightControlController(FlightControllService flightControllService) {
        this.flightControllService = flightControllService;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<Void> createFlight(@RequestBody String delJson) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        FlightDTO flightDTO = gson.fromJson(delJson, FlightDTO.class);
        this.flightControllService.addFlight(new Flight(flightDTO.departureDate, flightDTO.arrivalDate, flightDTO.departing,
                flightDTO.arriving, flightDTO.checkInOpens, flightDTO.status, flightDTO.economClassSeat,
                flightDTO.firstClassSeat, flightDTO.businessClassSeat, flightDTO.economClassPrice,
                flightDTO.firstClassPrice, flightDTO.businessClassPrice));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    }

