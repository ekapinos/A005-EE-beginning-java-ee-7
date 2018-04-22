package local.kapinos.chapter06;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import local.kapinos.chapter06.part01.C07_P01_Address;
import local.kapinos.chapter06.part01.C07_P01_Customer;
import local.kapinos.chapter06.part01.C07_P01_CustomerDTO;
import local.kapinos.chapter06.part01.C07_P01_Customer_;

@Startup
@Singleton
public class StartupSingleton {

	Logger logger = Logger.getLogger(getClass().getName());

	@PersistenceContext
	EntityManager em;
	
	long customerId;
	long addressId;

	@PostConstruct
	public void postConstruct() {
		logger.warning("Start (see log for SQL queries)");

		runPart01();
		runPart02();
		runPart03();
		runPart04();
		runPart06();
		runPart07();

		logger.warning("End");
	}

	protected void runPart01() {
		logger.info("part 01 - setup");
		
		C07_P01_Address address = new C07_P01_Address("street1", "city", "zipcode", "country");
		C07_P01_Customer customer = new C07_P01_Customer("firstName", "lastName", "email", address);

		em.persist(address);
		em.persist(customer);

		customerId = customer.getId();
		addressId = address.getId();
		em.flush();
		em.clear();

		C07_P01_Address address1 = new C07_P01_Address("street1*", "city*", "zipcode", "country");
		address1.setId(address.getId());
		// em.refresh(address1); Cannot refresh unmanaged object
		em.merge(address1); // UPDATE
	}

	protected void runPart02() {
		logger.info("part 02 - JPQL");

		em.flush();
		em.clear();

		// RAW fetch
		Query query = em.createQuery(
				"SELECT "
				+ "c.lastName, "
				+ "c.email, "
				+ "CASE WHEN c.id > 1 THEN 'ID greater than 1' ELSE 'ID is less then 2' END " + 
		        "FROM C07_P01_Customer c " + 
			    "WHERE c.firstName='firstName'");
		List<?> resultList = query.getResultList();
		for (Object row : resultList) {
			Object[] rowCells = (Object[]) row;
			String rowAsString = "";
			for (Object cell : rowCells) {
				rowAsString += cell.toString() + "; ";
			}
			logger.info(rowAsString); // -> "lastName; email; ID greater than 1; " - because address has ID=1
		}
		
		// Fetch via DTO (not @Entity)
		TypedQuery<C07_P01_CustomerDTO> query1 = em.createQuery(
				"SELECT NEW local.kapinos.chapter06.part01.C07_P01_CustomerDTO( "
				+ "c.lastName, "
				+ "c.email, "
				+ "CASE WHEN c.id > 1 THEN 'ID greater than 1' ELSE 'ID is less then 2' END "
				+ ") " + 
		        "FROM C07_P01_Customer c " + 
			    "WHERE c.firstName='firstName'", C07_P01_CustomerDTO.class);
		
		logger.info(query1.getResultList().toString());
		
		em.createQuery("SELECT c FROM C07_P01_Customer c WHERE c.address.zipcode IN ('a', 'b')").getResultList();
	}

	protected void runPart03() {
		logger.info("part 03 - bulk update/delete");
		
		C07_P01_Customer customer = em.find(C07_P01_Customer.class, customerId);
		logger.info(customer.toString());
		
		em.createQuery("UPDATE C07_P01_Customer c SET c.lastName='lastname*' ").executeUpdate();
		logger.info(customer.getLastName()); // -> "lastName"
		em.refresh(customer);
		logger.info(customer.getLastName()); // -> "lastName*"
	}

	protected void runPart04() {
		logger.info("part 04 - Criteria API with Metamodel");
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<C07_P01_Customer> criteriaQuery = builder.createQuery(C07_P01_Customer.class);
		Root<C07_P01_Customer> c = criteriaQuery.from(C07_P01_Customer.class);
		criteriaQuery.select(c).where(builder.equal(c.get(C07_P01_Customer_.firstName), "Vincent"));
		em.createQuery(criteriaQuery).getResultList();		
	}

	protected void runPart06() {
		logger.info("part 06 - stored procedures - not implemented");
		
		try{
		 // Derby requires Java class with implementation. To long to deploy
		 //em.createNativeQuery("DROP PROCEDURE addTwoAsterisks").executeUpdate();
		}
		catch (Exception e){
			logger.info(e.getMessage());
		}
	}

	protected void runPart07() {
		logger.info("part 07 - callbacks");
		
		C07_P01_Address address = em.find(C07_P01_Address.class, addressId);

		address.setCountry(address.getCountry() + "*");
	}
}
