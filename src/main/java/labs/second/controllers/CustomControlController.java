package labs.second.controllers;

import labs.second.services.CustomsControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("customControl")
public class CustomControlController {
    private final CustomsControlService customsControlService;

    @Autowired
    public CustomControlController(CustomsControlService customsControlService) {
        this.customsControlService = customsControlService;
    }

    @PostMapping("/greenLine")
    public ResponseEntity<Void> passControll(@RequestParam("id") UUID passangerId) {
        this.customsControlService.skipAndCheck(passangerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/redLine")
    public ResponseEntity<Void> passControll(@RequestParam("id") UUID passangerId, @RequestParam("description") String text) {
        this.customsControlService.declarateAndCheck(passangerId, text);
        return ResponseEntity.ok().build();
    }
}
