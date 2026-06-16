package executorservice.virtual;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static executorservice.SleepUtils.sleep;
import static java.util.stream.Collectors.toList;

public class GeneralTest {

    private static final long TASK_DURATION = 2_000;

    @Test
    void testVirtual() { //QJLI
        int taskCount = 10;
        List<Callable<String>> tasks = IntStream.range(0, taskCount)
                .mapToObj(this::createCallable)
                .toList();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sleep(5_000);
    }

    @Test
    void testVirtualThroughFactory() { //QF2Z
        int taskCount = 10;
        List<Callable<String>> tasks = IntStream.range(0, taskCount)
                .mapToObj(this::createCallable)
                .toList();

        ThreadFactory virtualFactory = Thread.ofVirtual().factory();
        try (ExecutorService executor = Executors.newFixedThreadPool(5, virtualFactory)) {
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sleep(5_000);
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
