package festivos.festivos.repositories;

import festivos.festivos.models.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestivoRepository extends JpaRepository<Festivo, Long> {
}
