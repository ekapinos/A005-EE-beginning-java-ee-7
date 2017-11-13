package local.kapinos.chapter03.constraint;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import local.kapinos.chapter03.qualifier.USA;
import local.kapinos.chapter03.service.ZipCodeChecker;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	@Inject
	@USA
	private ZipCodeChecker zipCodeChecker;
	
	@Override
	public void initialize(ZipCode constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return zipCodeChecker.isZipCodeValid(value);
	}

}
