package labs.second.controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import labs.second.services.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CheckInController {
    private final CheckInService checkInService;

    @Autowired
    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @PostMapping("/check_in")
    public ResponseEntity<String> checkInClient(@RequestParam("ticket_id") UUID id) {
        UUID uuid = this.checkInService.checkInClient(id);
        return new ResponseEntity<String>(String.valueOf(uuid), HttpStatus.OK);

    }


}
