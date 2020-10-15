package labs.second.controllers;


import labs.second.services.CheckInBaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CheckInBaggegeController {
    private final CheckInBaggageService checkInBaggageService;

    @Autowired
    public CheckInBaggegeController(CheckInBaggageService checkInBaggageService) {
        this.checkInBaggageService = checkInBaggageService;
    }

    @PostMapping("/checkInBaggage")
    public ResponseEntity<Void> checkInBaggage(@RequestParam("id") UUID passangerId, @RequestParam("weight") float weight) {
        this.checkInBaggageService.checkInBaggage(passangerId, weight);
        return ResponseEntity.ok().build();
    }
}
