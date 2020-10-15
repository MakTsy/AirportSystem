package labs.second.controllers;



import com.google.gson.Gson;
import labs.second.entities.Client;
import labs.second.services.BookingService;
import labs.second.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("client")
public class ClientController {
    private final ClientService clientService;
    private final BookingService bookingService;

    @Autowired
    public ClientController(ClientService clientService, BookingService bookingService) {
        this.clientService = clientService;
        this.bookingService = bookingService;
    }

    @PostMapping("/newOne")
    public ResponseEntity<UUID> createClient(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        Client client = new Client(name, surname);
        this.clientService.addClient(client);
        return new ResponseEntity<UUID>( client.getIdClient(), HttpStatus.OK);
    }
}
