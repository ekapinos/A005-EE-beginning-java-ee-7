package local.kapinos.chapter08.cdi;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {
	@Produces
	@PersistenceContext(unitName = "chapter08PU")
	private EntityManager em;
}
