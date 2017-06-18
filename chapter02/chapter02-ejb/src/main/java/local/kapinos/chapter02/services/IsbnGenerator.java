package local.kapinos.chapter02.services;

import java.util.Random;

import javax.inject.Inject;

import local.kapinos.chapter02.annotations.ThirteenDigits;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {
	
	@Inject
	@ThirteenDigits
	private String prefix13digits; // "13-"
	
	@Inject
	@ThirteenDigits
	private int editorNumber; // 84356

	@Override
	public String generateNumber() {
		return prefix13digits + editorNumber + "-" + Math.abs(new Random().nextInt());
	}

}
