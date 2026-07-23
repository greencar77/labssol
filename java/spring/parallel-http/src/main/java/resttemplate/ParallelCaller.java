package resttemplate;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static resttemplate.helper.SleepUtils.sleep;

public class ParallelCaller {

    private static final long TASK_DURATION = 5_000;

    public static void main(String[] args) {
        int taskCount = 10;
        List<Callable<String>> tasks = IntStream.range(0, taskCount)
                .mapToObj(ParallelCaller::createCallable)
                .toList();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            executor.invokeAll(tasks);
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Callable<String> createCallable(int taskId) {
        return () -> task(taskId);
    }

    private static String task(int taskId) {
        String threadName = Thread.currentThread().getName();
        System.out.println("Task %d started on %s (will last %d millis)".formatted(taskId, threadName, TASK_DURATION));

        Main.doGet();

        sleep(TASK_DURATION);
        System.out.println("Task %d finished on %s".formatted(taskId, threadName));
        return "Result from task " + taskId;
    }
}
