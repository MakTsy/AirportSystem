package labs.second.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;
    private String name;
    private String surname;

    public Client() {
    }

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String sayGreeting() {
        return "Hello! I am new here and i love travelling. My name is " + this.name + " " + this.surname;
    }

    public String getName() {
        return this.name;
    }

    public UUID getIdClient() {
        return this.id;
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
