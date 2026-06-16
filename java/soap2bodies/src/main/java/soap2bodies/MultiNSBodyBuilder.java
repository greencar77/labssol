package soap2bodies;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class MultiNSBodyBuilder {
	public SOAPMessage build() throws SOAPException {
		SOAPMessage message = MessageFactory.newInstance().createMessage();

		SOAPPart soapPart = message.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();

		SOAPBody body = envelope.getBody();
		body.addNamespaceDeclaration("ns", "http://example.com");

		SOAPElement child1 = body.addChildElement("Item1", "ns");
		child1.addTextNode("value1");

		SOAPElement child2 = body.addChildElement("Item2", "ns");
		child2.addTextNode("value2");

		addSmallTree(body, "TreeTop", "ns");

		return message;
	}

	private void addSmallTree(SOAPBody body, String childName, String childNS) throws SOAPException {
		SOAPElement child = body.addChildElement(childName, childNS);
		child.addNamespaceDeclaration("", "http://super.com");
		SOAPElement child2 = child.addChildElement("Something");
		child2.addTextNode("something");
	}
}
