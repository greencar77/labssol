package testpostgres.transfer.service;

import testpostgres.transfer.config.TransferServiceConfiguration;
import testpostgres.transfer.domain.Film;
import testpostgres.transfer.repository.FilmRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TransferServiceConfiguration.class)
public class TransferServiceTest {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private TransactionTemplate transactionTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private FilmRepository filmRepository;

    @BeforeEach
    public void init() {
        entityManagerFactory.unwrap(SessionFactoryImplementor.class)
            .getSchemaManager().truncateMappedObjects();

        transactionTemplate.execute((TransactionCallback<Void>) transactionStatus -> {
            Film film = new Film();
            film.setId(1);
            film.setTitle("Dune");

            entityManager.persist(film);

            return null;
        });
    }

    @Test
    public void test() {
        Film film = filmRepository.findById(1).get();
        assertEquals("Dune", film.getTitle());
    }
}
