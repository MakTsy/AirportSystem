package labs.second.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class BoardingPass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne
    private Client client;
    @OneToOne
    private Flight flight;
    private String sitClass;
    private int seat;
    private String gate;

    public BoardingPass(Ticket ticket, int seat, String gate) {
        this.gate = gate;
        this.seat = seat;
        this.client = ticket.getClient();
        this.flight = ticket.getFlight();
        this.sitClass = ticket.getSitClass();
    }

    public BoardingPass() {
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setSitClass(String sitClass) {
        this.sitClass = sitClass;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public Client getClient() {
        return client;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getSeat() {
        return seat;
    }

    public String getGate() {
        return gate;
    }

    public String getSitClass() {
        return sitClass;
    }
}
