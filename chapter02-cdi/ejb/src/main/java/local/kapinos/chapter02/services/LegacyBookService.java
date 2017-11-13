package local.kapinos.chapter02.services;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import local.kapinos.chapter02.qualifier.EightDigits;

@Alternative
public class LegacyBookService extends AbstractBookService{
	
	@Inject
	public LegacyBookService(@EightDigits NumberGenerator numberGenerator) {
		super(numberGenerator);
	}
}
