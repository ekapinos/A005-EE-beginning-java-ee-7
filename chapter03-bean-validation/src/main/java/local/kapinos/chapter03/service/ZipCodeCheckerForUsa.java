package local.kapinos.chapter03.service;

import local.kapinos.chapter03.qualifier.USA;

@USA
public class ZipCodeCheckerForUsa implements ZipCodeChecker{

	@Override
	public boolean isZipCodeValid(String zipCode) {
		if (zipCode == null){
			return true;
		}
		return zipCode.startsWith("us");
	}

}
