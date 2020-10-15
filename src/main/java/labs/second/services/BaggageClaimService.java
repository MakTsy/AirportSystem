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
public class BaggageClaimService {
    private final BaggageRepository baggageRepository;
    private final PassengerRepository passengerRepository;

    @Autowired
    public BaggageClaimService(BaggageRepository baggageRepository, PassengerRepository passengerRepository) {
        this.baggageRepository = baggageRepository;
        this.passengerRepository = passengerRepository;
    }

    @Transactional
    public Baggage dropBaggage(UUID id) {
        Passenger passenger = this.passengerRepository.findById(id).orElseThrow();
        Baggage baggage = passenger.getBaggage();
        passenger.setBaggage(null);
        this.passengerRepository.save(passenger);
        this.baggageRepository.deleteById(baggage.getId());
        return baggage;
    }
}
