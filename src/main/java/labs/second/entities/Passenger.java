package labs.second.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPassanger;
    @OneToOne
    private Baggage baggage;
    @OneToOne
    private BoardingPass boardingPass;
    private String passportControlCheck;
    private String customsControlCheck;
    private String preFlightCheck;

    public Passenger() {
    }

    public UUID getPassangerId() {
        return idPassanger;
    }

    public BoardingPass getBoardingPass() {
        return boardingPass;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public void setCustomsControlCheck(String customsControlCheck) {
        this.customsControlCheck = customsControlCheck;
    }

    public void setPassportControlCheck(String passportControlCheck) {
        this.passportControlCheck = passportControlCheck;
    }

    public void setPreFlightCheck(String preFlightCheck) {
        this.preFlightCheck = preFlightCheck;
    }

    public void setBoardingPass(BoardingPass boardingPass) {
        this.boardingPass = boardingPass;
    }

    public void setBaggage(Baggage baggage) {
        this.baggage = baggage;
    }
}
