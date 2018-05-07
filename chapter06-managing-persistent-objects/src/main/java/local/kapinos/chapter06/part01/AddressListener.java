package local.kapinos.chapter06.part01;

import java.util.logging.Logger;

import javax.persistence.PostUpdate;

public class AddressListener {
	
	Logger logger = Logger.getLogger(getClass().getName());

	@PostUpdate
	public void address(C06_P01_Address address) {
		logger.info(getClass().getSimpleName() + " - @PostUpdate - " + address);
	}
}
