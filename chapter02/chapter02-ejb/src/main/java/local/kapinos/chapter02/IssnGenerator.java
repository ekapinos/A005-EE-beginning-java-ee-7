package local.kapinos.chapter02;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IssnGenerator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "8-" + Math.abs(new Random().nextInt());
	}

}
