package testpostgres.transfer.repository;

import testpostgres.transfer.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface FilmRepository extends JpaRepository<Film, Integer> {
}
