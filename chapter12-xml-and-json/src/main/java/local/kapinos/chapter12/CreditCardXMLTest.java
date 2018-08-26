package local.kapinos.chapter12;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CreditCardXMLTest {

	private Logger logger = Logger.getLogger(getClass().getName());

	public static final String creditCardXML = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
			+ "<creditCard number=\"12345678\">\n"
			+ " <expiry_date>10/14</expiry_date>\n"
			+ " <control_number>566</control_number>\n"
			+ " <type>Visa</type>\n"
			+ "</creditCard>";

	// @Test
	public void shouldMarshallACreditCard() throws JAXBException {
		CreditCard creditCard = new CreditCard("12345678", "10/14", 566, "Visa");
		StringWriter writer = new StringWriter();
		
		JAXBContext context = JAXBContext.newInstance(CreditCard.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(creditCard, writer);
		
		logger.info(writer.toString());
		// assertEquals(creditCardXML, writer.toString().trim());
	}

	// @Test
	public void shouldUnmarshallACreditCard() throws JAXBException {
		StringReader reader = new StringReader(creditCardXML);
		
		JAXBContext context = JAXBContext.newInstance(CreditCard.class);
		Unmarshaller u = context.createUnmarshaller();
		CreditCard creditCard = (CreditCard) u.unmarshal(reader);
		// assertEquals("12345678", creditCard.getNumber());
		// assertEquals("10/14", creditCard.getExpiryDate());
		// assertEquals((Object) 566, creditCard.getControlNumber());
		// assertEquals("Visa", creditCard.getType());
		logger.info(creditCard.toString());
	}

	public void saxVsStax() throws SAXException, IOException, ParserConfigurationException, XMLStreamException {
		ByteArrayInputStream targetStream = new ByteArrayInputStream(creditCardXML.getBytes("UTF-8"));
		logger.info("SAX");
		// SAX Factory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		
		// Parsing the document
		saxParser.parse(targetStream, new DefaultHandler() {
			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				logger.info(qName);
			}
			
			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				String str =  new String(ch, start, length).trim();
				if (str.isEmpty())  return;
				logger.info(str);
			}
		});

		logger.info("StAX");
		targetStream.reset();
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(targetStream);
        while(xmlEventReader.hasNext())
        {
        	XMLEvent event = xmlEventReader.nextEvent();
        	logger.info(event.getClass().toString() + " \t "+ event.toString());
        }
	}
}
