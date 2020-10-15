package labs.second.services;

import labs.second.repo.FlightRepository;
import labs.second.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlightControllService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightControllService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Transactional
    public void addFlight(Flight flight) {
        this.flightRepository.save(flight);
    }

    @Transactional
    public List<Flight> getFlights() {
        return this.flightRepository.findAll();
    }

    @Transactional
    public void updateFlight(Flight flight) {
        this.flightRepository.save(flight);
    }

    @Transactional
    public void deleteFlight(Flight flight) {
        this.flightRepository.delete(flight);
    }

    @Transactional
    public Flight getFlight(UUID id) {
        return this.flightRepository.findById(id).orElseThrow();

    }
}
