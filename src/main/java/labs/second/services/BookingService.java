package labs.second.services;

import labs.second.entities.Client;
import labs.second.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import labs.second.repo.TicketRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {
    public final TicketRepository ticketRepository;

    @Autowired
    public BookingService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    @Transactional
    public UUID bookTicket(Ticket ticket) {
        this.ticketRepository.save(ticket);
        return ticket.getIdTicket();
    }

    @Transactional
    public Ticket getTicket(UUID id) {
        return this.ticketRepository.findById(id).orElseThrow();
    }

}
