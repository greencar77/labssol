package pkb.log4j2kb;

import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void test() {
        Helios o = new Helios();
        o.something();
        try {
            Thread.sleep(1000); //let the logging stream (System.err) output everything
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testStackTrace() {
        Helios o = new Helios();
        o.toStr();
    }

    @Test
    public void testStackTraceAsVariables() {
        Helios o = new Helios();
        o.toStrVariables();
    }
}