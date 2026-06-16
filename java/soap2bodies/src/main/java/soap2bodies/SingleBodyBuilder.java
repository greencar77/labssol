package soap2bodies;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class SingleBodyBuilder {
	public SOAPMessage build() throws SOAPException {
		SOAPMessage message = MessageFactory.newInstance().createMessage();

		SOAPPart soapPart = message.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("ns", "http://example.com");
		SOAPBody body = envelope.getBody();

		SOAPElement child1 = body.addChildElement("Item1", "ns");
		child1.addTextNode("value1");

		SOAPElement child2 = body.addChildElement("Item2", "ns");
		child2.addTextNode("value2");

		return message;
	}
}
