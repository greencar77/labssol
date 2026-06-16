package pkb.saajdemo;

import static soap2bodies.Utils.output;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.junit.jupiter.api.Test;

import soap2bodies.HeaderBuilder;
import soap2bodies.DocumentBodyBuilder;
import soap2bodies.MultiNSBodyBuilder;
import soap2bodies.SingleBodyBuilder;
import soap2bodies.SingleBodyWrapBuilder;
import soap2bodies.XMultiNSBodyBuilder;

public class MainTest {

	@Test
	public void test() throws SOAPException, ParserConfigurationException {
		HeaderBuilder builder = new HeaderBuilder();
		SOAPMessage soapMessage = builder.build();
		output(soapMessage, "output/sample.xml");
	}

	@Test
	public void testSingleBody() throws SOAPException { //QAJF
		SingleBodyBuilder builder = new SingleBodyBuilder();
		SOAPMessage soapMessage = builder.build();
		output(soapMessage, "output/single_body.xml");
	}

	@Test
	public void testSingleBodyWrap() throws SOAPException, ParserConfigurationException {
		SingleBodyWrapBuilder builder = new SingleBodyWrapBuilder();
		SOAPMessage soapMessage = builder.build();
		output(soapMessage, "output/single_body_wrap.xml");
	}

	@Test
	public void testMultiNSBody() throws SOAPException {
		MultiNSBodyBuilder builder = new MultiNSBodyBuilder();
		SOAPMessage soapMessage = builder.build();
		output(soapMessage, "output/multi_ns.xml");
	}

	@Test
	public void testXMultiNSBody() throws SOAPException { //QLIU
		XMultiNSBodyBuilder builder = new XMultiNSBodyBuilder();
		SOAPMessage soapMessage = builder.build();
		output(soapMessage, "output/multi_ns_x.xml");
	}

	@Test
	public void testDocumentBody() throws SOAPException, ParserConfigurationException {
		DocumentBodyBuilder builder = new DocumentBodyBuilder();
		SOAPMessage soapMessage = builder.build();
		output(soapMessage, "output/document_body.xml");
	}
}