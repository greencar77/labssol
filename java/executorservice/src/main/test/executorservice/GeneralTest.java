package executorservice;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static executorservice.SleepUtils.sleep;

public class GeneralTest {

    private static final long TASK_DURATION = 2_000;

    @Test
    void testFixedThreadPool() { //QXZ9
        int taskCount = 100;
        List<Callable<String>> tasks = IntStream.range(0, taskCount)
                .mapToObj(this::createCallable)
                .toList();

        ExecutorService executor = Executors.newFixedThreadPool(20);
        try {
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
    void testCachedThreadPool() { //QT2J
        int taskCount = 100;
        List<Callable<String>> tasks = IntStream.range(0, taskCount)
                .mapToObj(this::createCallable)
                .toList();

        ExecutorService executor = Executors.newCachedThreadPool();
        try {
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
    void testScheduled() { //QHMH
        int taskId = 7;
        Runnable callableTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.printf("Task %d started on %s%n", taskId, threadName);
            sleep(TASK_DURATION);
            System.out.printf("Task %d finished on %s%n", taskId, threadName);
        };

        System.out.println("before");
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(callableTask, 7, 5, TimeUnit.SECONDS);
        System.out.println("after");
        sleep(20_000);
    }

    private Callable<String> createCallable(int taskId) {
        return () -> task(taskId);
    }

    private String task(int taskId) {
        String threadName = Thread.currentThread().getName();
        System.out.println("Task %d started on %s (will last %d millis)".formatted(taskId, threadName, TASK_DURATION));
        sleep(TASK_DURATION);
        System.out.println("Task %d finished on %s".formatted(taskId, threadName));
        return "Result from task " + taskId;
    }
}
