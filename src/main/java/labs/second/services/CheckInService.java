package labs.second.services;

import labs.second.repo.PassengerRepository;
import labs.second.repo.BoardingPassRepository;
import labs.second.repo.TicketRepository;
import labs.second.entities.BoardingPass;
import labs.second.entities.Passenger;
import labs.second.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CheckInService {
    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final BoardingPassRepository boardingPassRepository;


    @Autowired
    public CheckInService(TicketRepository ticketRepository, PassengerRepository passengerRepository, BoardingPassRepository boardingPassRepository) {
        this.passengerRepository = passengerRepository;
        this.ticketRepository = ticketRepository;
        this.boardingPassRepository = boardingPassRepository;
    }

    @Transactional
    public UUID checkInClient(UUID ticketId) {
        Passenger passenger = new Passenger();
        Ticket ticket = this.ticketRepository.findById(ticketId).orElseThrow();
        BoardingPass boardingPass = new BoardingPass(ticket, 21, "DefaultGate");
        this.boardingPassRepository.save(boardingPass);
        passenger.setBoardingPass(boardingPass);
        this.passengerRepository.save(passenger);
        return passenger.getPassangerId();
    }

    @Transactional
    public BoardingPass getBoardingPass(UUID id) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow();
        return passenger.getBoardingPass();
    }
}
