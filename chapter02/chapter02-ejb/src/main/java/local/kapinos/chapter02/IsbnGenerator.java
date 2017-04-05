package local.kapinos.chapter02;

import java.util.Random;

import javax.enterprise.inject.Alternative;

@Alternative
public class IsbnGenerator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "13-84356-" + Math.abs(new Random().nextInt());
	}

}
