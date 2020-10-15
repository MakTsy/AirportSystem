package labs.second.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import labs.second.entities.Ticket;
import labs.second.entities.dto.FlightDTO;
import labs.second.entities.dto.TicketDTO;
import labs.second.services.BookingService;
import labs.second.services.ClientService;
import labs.second.services.FlightControllService;
import labs.second.services.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BookingController {
    private final BookingService bookingService;
    private final PayService payService;
    private final FlightControllService flightControllService;
    private final ClientService clientService;

    @Autowired
    public BookingController(BookingService bookingService,PayService payService,
                             FlightControllService flightControllService, ClientService clientService) {
        this.bookingService = bookingService;
        this.payService = payService;
        this.clientService = clientService;
        this.flightControllService = flightControllService;
    }

    @RequestMapping(value="booking",method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<String> bookTicket(@RequestBody String delJson) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        TicketDTO ticketDTO = gson.fromJson(delJson, TicketDTO.class);
        UUID id = this.bookingService.bookTicket(new Ticket(this.clientService.getCliennt(ticketDTO.clientId),
               this.flightControllService.getFlight(ticketDTO.flightId), ticketDTO.sitClass));
        this.flightControllService.getFlight(ticketDTO.flightId).changeClassSit(ticketDTO.sitClass);
        this.clientService.setTicket(ticketDTO.clientId, this.bookingService.getTicket(id));
        this.payService.pay(this.bookingService.getTicket(id));
        return new ResponseEntity<String>(String.valueOf(id),HttpStatus.OK);
    }



}
