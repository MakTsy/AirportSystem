package labs.second.services;

import labs.second.repo.PassengerRepository;
import labs.second.entities.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class PreFlightInspectionService {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PreFlightInspectionService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Transactional
    public String inspect( UUID id) {
        Passenger passenger  = this.passengerRepository.findById(id).orElseThrow();
        passenger.setPreFlightCheck("Passed");
        this.passengerRepository.save(passenger);
        return "Passanger: " + id + " you have successfully passed Security control";
    }
}
