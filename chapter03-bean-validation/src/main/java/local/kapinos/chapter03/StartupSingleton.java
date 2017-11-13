package local.kapinos.chapter03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import local.kapinos.chapter03.model.Address;
import local.kapinos.chapter03.model.Customer;

@Startup	
@Singleton
public class StartupSingleton {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	private Validator validator;
	
	@PostConstruct
	public void postConstruct() {
		logger.warning("Start");
		
		Date pastDate = null, futureDate = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			pastDate   = dateFormat.parse("2017-11-14");
			futureDate = dateFormat.parse("3017-11-14");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Address addressOk = new Address("street", "street2", "city", "state", "us-123", "country");
		Address addressNotOk = new Address(null, "street2", "city", "state", "zipCode", "country");
		
		validateAndLog(addressOk);
		validateAndLog(addressNotOk);
		validateAndLog(new Customer("firstName", "lastName", "email@email.com", "phoneNumber", pastDate, addressOk));
		validateAndLog(new Customer("fir", "lastName", "email_email.com", "phoneNumber", futureDate, addressNotOk));
		
		logger.warning("End");
	}
	
	private void validateAndLog(Object object){
		Set<ConstraintViolation<Object>> result = validator.validate(object);

		logger.warning("- " + object.toString());

		if (result.size() == 0){
			logger.warning("-- OK");
		} else {
			for(ConstraintViolation<Object> violation : result){
				logger.warning("-- " + violation);		
			}
		}
	}
}
