package labs.second.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private float baggageWeight;

    public Baggage(float baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public Baggage() {
    }

    public void setBaggageWeight(float baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public UUID getId() {
        return id;
    }
}
