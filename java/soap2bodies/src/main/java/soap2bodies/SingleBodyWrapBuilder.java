package soap2bodies;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SingleBodyWrapBuilder {
	public SOAPMessage build() throws SOAPException, ParserConfigurationException {
		SOAPMessage message = MessageFactory.newInstance().createMessage();

		SOAPPart soapPart = message.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("ns", "http://example.com");
		SOAPBody body = envelope.getBody();
		SOAPElement container = body.addChildElement("Container", "ns");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc1 = builder.newDocument();
//		Element root1 = doc1.createElement("Customer");
		Element root1 = doc1.createElementNS("http://example.com", "ns:Customer");
		root1.appendChild(doc1.createTextNode("Alice"));
		doc1.appendChild(root1);

		// Second XML document
		Document doc2 = builder.newDocument();
//		Element root2 = doc2.createElement("Order");
		Element root2 = doc2.createElementNS("http://example.com", "ns:Order");
		root2.appendChild(doc2.createTextNode("12345"));
		doc2.appendChild(root2);

		Node imported1 = container.getOwnerDocument().importNode(doc1.getDocumentElement(), true);
		Node imported2 = container.getOwnerDocument().importNode(doc2.getDocumentElement(), true);

		container.appendChild(imported1);
		container.appendChild(imported2);

		return message;
	}
}
