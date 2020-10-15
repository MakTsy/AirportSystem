package labs.second.repo;

import labs.second.entities.BoardingPass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardingPassRepository extends JpaRepository<BoardingPass, UUID> {
}
