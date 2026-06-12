package hashmapthread;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import static labs.javalang.SleepUtils.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneralTest {

    @Test
    void testHashMap() {
        final int loopLimit = 1000;
        HashMap<Integer, String> map = new HashMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < loopLimit; i++) {
                map.put(i, "A");
            }
            System.out.println("Thread1 ended");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < loopLimit; i++) {
                map.put(i, "B");
            }
            System.out.println("Thread2 ended");
        });

        t1.start();
        t2.start();
        sleep(5000);

        assertEquals(loopLimit, map.size(), "Keys: " + map.keySet());
    }

    @Test
    void testConcurrentHashMap() {
        final int loopLimit = 1000;
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < loopLimit; i++) {
                map.put(i, "A");
            }
            System.out.println("Thread1 ended");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < loopLimit; i++) {
                map.put(i, "B");
            }
            System.out.println("Thread2 ended");
        });

        t1.start();
        t2.start();
        sleep(5000);

        assertEquals(loopLimit, map.size(), "Keys: " + map.keySet());
    }
}
