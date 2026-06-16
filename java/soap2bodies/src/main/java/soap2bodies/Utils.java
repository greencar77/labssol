package soap2bodies;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class Utils {
	public static void output(SOAPMessage soapMessage, String path) throws SOAPException {
		File file = new File(path);
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			soapMessage.writeTo(outputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println(file.getAbsolutePath());
	}
}
