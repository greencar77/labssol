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

public class DocumentBodyBuilder {
	public SOAPMessage build() throws SOAPException, ParserConfigurationException {
		SOAPMessage message = MessageFactory.newInstance().createMessage();

		SOAPPart soapPart = message.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();

		SOAPBody body = envelope.getBody();
		body.addNamespaceDeclaration("ns", "http://example.com");

		Document document = createDocument();

		Node importedRoot = body.getOwnerDocument().importNode(
				document.getDocumentElement(),
				true  // deep copy
		);

		body.appendChild(importedRoot);

		message.saveChanges();

		return message;
	}

	private Document createDocument() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.newDocument();
		Element root = doc.createElementNS("http://doc.com", "Customer");
		root.setTextContent("Alice");
		doc.appendChild(root);

		return doc;
	}
}
