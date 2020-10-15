package labs.second.controllers;

import labs.second.services.BaggageClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BaggageClaimController {
    private final BaggageClaimService baggageClaimService;

    @Autowired
    public BaggageClaimController(BaggageClaimService baggageClaimService) {
        this.baggageClaimService = baggageClaimService;
    }

    @PostMapping("/getMyBaggage")
    public ResponseEntity<Void> getBaggage(@RequestParam("id") UUID baggageId) {
        this.baggageClaimService.dropBaggage(baggageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
