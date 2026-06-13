package hashmapthread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static labs.javalang.SleepUtils.sleep;

public class GeneralTest {

    @Test
    void testFixedThreadPool() { //QXZ9
        int taskCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            List<Callable<String>> tasks = new ArrayList<>();
            for (int i = 1; i <= taskCount; i++) {
                int taskId = i;
                tasks.add(() -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.printf("Task %d started on %s%n", taskId, threadName);
                    sleep(2000);
                    System.out.printf("Task %d finished on %s%n", taskId, threadName);
                    return "Result from task " + taskId;
                });
            }

            List<Future<String>> futures = executor.invokeAll(tasks);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    @Test
    void testScheduled() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        int taskId = 7;
        Runnable callableTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.printf("Task %d started on %s%n", taskId, threadName);
            sleep(2000);
            System.out.printf("Task %d finished on %s%n", taskId, threadName);
        };

        System.out.println("before");
        executor.scheduleAtFixedRate(callableTask, 7, 5, TimeUnit.SECONDS);
        System.out.println("after");
        sleep(20_000);
    }
}
