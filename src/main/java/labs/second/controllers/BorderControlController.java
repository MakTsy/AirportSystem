package labs.second.controllers;


import labs.second.services.BorderControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("borderControl")
public class BorderControlController {
    private final BorderControlService borderControlService;

    @Autowired
    public BorderControlController(BorderControlService borderControlService) {
        this.borderControlService = borderControlService;
    }

    @PostMapping
    public ResponseEntity<Void> passControll(@RequestParam("id") UUID passangerId) {
        this.borderControlService.checkPassanger(passangerId);
        return ResponseEntity.ok().build();
    }

}
