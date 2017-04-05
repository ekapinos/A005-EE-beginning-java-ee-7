package local.kapinos.chapter02;

import java.util.Random;

@EightDigits
public class IssnGenerator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "8-" + Math.abs(new Random().nextInt());
	}

}
