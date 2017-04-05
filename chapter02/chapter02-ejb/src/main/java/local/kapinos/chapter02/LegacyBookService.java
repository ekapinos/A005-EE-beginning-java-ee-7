package local.kapinos.chapter02;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Alternative
public class LegacyBookService extends AbstractBookService{
	
	@Inject
	public LegacyBookService(@EightDigits NumberGenerator numberGenerator) {
		super(numberGenerator);
	}
}
