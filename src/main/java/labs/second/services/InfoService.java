package labs.second.services;

import labs.second.repo.FlightRepository;
import labs.second.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class InfoService {
    private final FlightRepository flightRepository;

    @Autowired
    public InfoService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Transactional
    public List<Flight> getInformationAboutFlights() {
        List<Flight> flights = this.flightRepository.findAll();
        return  flights;
    }
}
