package local.kapinos.chapter03.producers;

import java.util.Random;

import javax.enterprise.inject.Produces;

import local.kapinos.chapter03.qualifier.RandomDouble;
import local.kapinos.chapter03.qualifier.ThirteenDigits;

public class NumberProducer {
	
	@Produces
	@ThirteenDigits
	private String prefix13digits = "13-";
	
	@Produces
	@ThirteenDigits
	private int editorNumber = 84356;

	@Produces
	@RandomDouble
	public double random() {
		return Math.abs(new Random().nextInt());
	}
}
