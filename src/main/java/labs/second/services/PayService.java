package labs.second.services;

import labs.second.repo.TicketRepository;
import labs.second.entities.Ticket;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PayService {
    private final TicketRepository ticketRepository;

    public PayService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public void pay(Ticket ticket) {
        ticket.setPayed(true);
        this.ticketRepository.save(ticket);
    }

}
