package local.kapinos.chapter03.services;

import java.util.Random;

import local.kapinos.chapter03.qualifier.EightDigits;

@EightDigits
public class IssnGenerator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "8-" + Math.abs(new Random().nextInt());
	}

}
