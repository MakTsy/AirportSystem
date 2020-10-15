package labs.second.repo;

import labs.second.entities.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface BaggageRepository extends JpaRepository<Baggage, UUID> {
}
