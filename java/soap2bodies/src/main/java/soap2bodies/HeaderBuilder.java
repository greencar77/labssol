package soap2bodies;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.Document;

public class HeaderBuilder {
	public SOAPMessage build() throws SOAPException, ParserConfigurationException {
		SOAPMessage message = MessageFactory.newInstance().createMessage();

		SOAPHeader header = message.getSOAPHeader();
		SOAPHeaderElement headerElement = header.addHeaderElement(new QName("http://eee", "LocalPart", "eee"));
		//append child elements
		SOAPElement soapElement = buildSoapElement("eee", "rt", "http://rt", "valuex");
		headerElement.addChildElement(soapElement);
		headerElement.addChildElement(buildSoapElement("empty", "", "http://empty", "valueY"));
		headerElement.addChildElement(buildSoapElement("emptyNull", null, "http://empty2", "valueY"));
		headerElement.addChildElement(new QName("http://li", "Limbo", "li"));
		soapElement = buildSoapElement("qqq", "pref", "http://pref", "valuew");
		soapElement.addNamespaceDeclaration("jjj", "http://jjj");
		headerElement.addChildElement(soapElement);
		headerElement.addChildElement(buildSoapElement("bgh", "factory.createElement(name)"));

		QName qname = new QName("http://q", "Qwer", "q");
		SOAPHeaderElement orderHeader = header.addHeaderElement(qname);
		//		orderHeader.setValue("QName(\"http://q\", \"Qwer\", \"q\")");

		qname = new QName("http://u", "QwerSub", "u");
		SOAPElement s = orderHeader.addChildElement(qname);
		s.setValue("QwerSubValue");

		SOAPHeaderElement header3 = header.addHeaderElement(new QName("http://he", "He", "he"));
		SOAPElement s3 = header3.addChildElement("Alpha", "cc", "http://cc");
		s3.setValue("AlphaValue");

		Document document = buildDocument();
		message.getSOAPBody().addDocument(document);

		return message;
	}

	private Document buildDocument() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		return factory.newDocumentBuilder().newDocument();
	}

	private SOAPElement buildSoapElement(String name, String prefix, String uri, String value) throws SOAPException {
		SOAPFactory factory = SOAPFactory.newInstance();
		//com.sun.xml.messaging.saaj.soap.ver1_1.SOAPFactory1_1Impl
		//extends com.sun.xml.messaging.saaj.soap.SOAPFactoryImpl
		//calls com.sun.xml.messaging.saaj.soap.impl.ElementFactory
		SOAPElement soapElement = factory.createElement(name, prefix, uri);
		soapElement.addTextNode(value);
		return soapElement;
	}

	private SOAPElement buildSoapElement(String name, String value) throws SOAPException {
		SOAPFactory factory = SOAPFactory.newInstance();
		SOAPElement soapElement = factory.createElement(name);
		soapElement.addTextNode(value);
		return soapElement;
	}
}
