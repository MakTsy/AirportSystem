package labs.second.controllers;

import com.google.gson.Gson;
import labs.second.entities.Flight;
import labs.second.entities.Ticket;
import labs.second.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("info")
public class InfoController {
    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping(value="/allFlights", produces = "application/json")
    public ResponseEntity<String> getFlights() {
        Gson json = new Gson();
        String ans = json.toJson(this.infoService.getInformationAboutFlights());
        return new ResponseEntity<String>(ans, HttpStatus.OK);
    }

}
