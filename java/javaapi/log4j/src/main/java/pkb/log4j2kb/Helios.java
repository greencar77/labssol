package pkb.log4j2kb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Helios {
    private static Logger LOG = LogManager.getLogger(Helios.class);

	public void something() {
        //testProps("log4j2.properties");

		System.out.println("LOG.getClass().getName()=" + LOG.getClass().getName());

		LOG.info("INFO something()");
		LOG.debug("DEBUG something()");
	}

	public void toStr() {
		LOG.info("alpha=" + new Alpha());
	}

	public void toStrVariables() {
		LOG.info("alpha={}", new Alpha());
	}

	public static void testProps(String filename) {
        Properties props = new Properties();
        try {
            final InputStream inStream = Helios.class.getClassLoader().getResourceAsStream(filename);
            if (inStream != null) {
                props.load(inStream);
            } else {
                System.out.println("not on classpath");
            }
        } catch (IOException e) {
            LOG.error("Exception ", e);
        }

        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            System.out.println(entry);
        }

    }
}
