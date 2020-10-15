package labs.second.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTicket;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Flight flight;
    private String sitClass;
    boolean payed;

    public Ticket(Client client, Flight flight, String sitClass) {
        this.client = client;
        this.flight = flight;
        this.sitClass = sitClass;
        this.payed = false;
    }
    public Ticket() {
    }

    public UUID getIdTicket() {
        return this.idTicket;
    }

    public String getSitClass() {
        return this.sitClass;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public UUID getClientId() {
        return this.client.getIdClient();
    }

    public Client getClient() {
        return this.client;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public boolean isPayed() {
        return this.payed;
    }
}
