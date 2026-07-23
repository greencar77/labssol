package resttemplate.helper;

import java.util.concurrent.TimeUnit;

public class SleepUtils {

    public static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
