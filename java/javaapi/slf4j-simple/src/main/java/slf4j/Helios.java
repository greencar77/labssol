package slf4j;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.SimpleLogger;

public class Helios {
	private static final Logger LOG = LoggerFactory.getLogger(Helios.class);
	
	public void something() {
		System.out.println("LOG.getClass().getName()=" + LOG.getClass().getName());
		
		Validate.isTrue(LOG instanceof SimpleLogger);
		
		LOG.info("INFO something()");
		LOG.debug("DEBUG something()");
	}
}
