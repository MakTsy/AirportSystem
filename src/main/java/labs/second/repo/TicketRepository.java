package labs.second.repo;

import labs.second.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    @Query("SELECT t FROM Ticket  t INNER JOIN Client c ON  t.client.id = c.id")
    List<Ticket> findTicketByclient_id(@Param("client_id") UUID client_id);

}
