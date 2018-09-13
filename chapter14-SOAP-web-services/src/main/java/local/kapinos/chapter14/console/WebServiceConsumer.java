package local.kapinos.chapter14.console;

import local.kapinos.chapter14.console.generated.CardValidator;
import local.kapinos.chapter14.console.generated.CardValidatorService;
import local.kapinos.chapter14.console.generated.CreditCard;

public class WebServiceConsumer {
	
	public static void main(String[] args) {
		
		CreditCard creditCard = new CreditCard();
		creditCard.setNumber("12341234");
		creditCard.setExpiryDate("10/12");
		creditCard.setType("VISA");
		creditCard.setControlNumber(1234);

		// last digit in credit card number odd -> false, last even - > true
		// e.g.  12341234 -> true
		CardValidator cardValidator = new CardValidatorService().getCardValidatorPort();
		System.out.println(cardValidator.validate(creditCard));
	}
}
