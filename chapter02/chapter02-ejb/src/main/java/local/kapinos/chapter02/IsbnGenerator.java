package local.kapinos.chapter02;

import java.util.Random;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "13-84356-" + Math.abs(new Random().nextInt());
	}

}
