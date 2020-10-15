package labs.second.controllers;

import labs.second.services.PreFlightInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("flightControl")
public class PreFlightInspectionController {
    private final PreFlightInspectionService preFlightInspectionService;

    @Autowired
    public PreFlightInspectionController(PreFlightInspectionService preFlightInspectionService) {
        this.preFlightInspectionService = preFlightInspectionService;
    }

    @PostMapping
    public ResponseEntity<Void> passControll(@RequestParam("id") UUID passangerId) {
        this.preFlightInspectionService.inspect(passangerId);
        return ResponseEntity.ok().build();
    }
}
