package labs.second.services;

import labs.second.entities.Baggage;
import labs.second.entities.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import labs.second.repo.BaggageRepository;
import labs.second.repo.PassengerRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CheckInBaggageService {
    private final BaggageRepository baggageRepository;
    private final PassengerRepository passengerRepository;

    @Autowired
    public CheckInBaggageService(BaggageRepository baggageRepository, PassengerRepository passengerRepository) {
        this.baggageRepository = baggageRepository;
        this.passengerRepository = passengerRepository;
    }

    @Transactional
    public void checkInBaggage(UUID passangerId, float bagageWeight) {
        Baggage baggage = new Baggage(bagageWeight);
        this.baggageRepository.save(baggage);
        Passenger passenger = this.passengerRepository.findById(passangerId).orElseThrow();
        passenger.setBaggage(baggage);
        this.passengerRepository.save(passenger);

    }


}
