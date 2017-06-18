package local.kapinos.chapter02.services;

import java.util.Random;

import local.kapinos.chapter02.annotations.EightDigits;

@EightDigits
public class IssnGenerator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "8-" + Math.abs(new Random().nextInt());
	}

}
