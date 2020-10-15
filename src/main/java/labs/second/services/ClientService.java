package labs.second.services;

import labs.second.entities.Client;
import labs.second.entities.Ticket;
import labs.second.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import labs.second.repo.ClientRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void addClient(Client client) {
        this.clientRepository.save(client);
    }


    @Transactional
    public Client getCliennt(UUID id) {
        return this.clientRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void setTicket(UUID id, Ticket ticket) {
        Client client = this.clientRepository.findById(id).orElseThrow();
        client.addTicket(ticket);
    }

}