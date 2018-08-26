package local.kapinos.chapter12;

import java.util.logging.Logger;

public class Startup {

	static {
		String path = Startup.class.getClassLoader()
                .getResource("logging.properties")
                .getFile();
        System.setProperty("java.util.logging.config.file", path);
	}

	private static Logger logger = Logger.getLogger(Startup.class.getName());

	public static void main(String[] args) throws Exception {
		
		logger.info("@PostConstruct");
		
		CreditCardXMLTest test = new CreditCardXMLTest();
		test.shouldMarshallACreditCard();
		test.shouldUnmarshallACreditCard();
		test.saxVsStax();
		
		CreditCardJSonTest jsonTest = new CreditCardJSonTest();
		jsonTest.shouldGenerateACreditCard();
		
		logger.info("@PreDestroy");
	}
}