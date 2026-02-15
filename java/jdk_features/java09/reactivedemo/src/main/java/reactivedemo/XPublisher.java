package reactivedemo;

import static reactivedemo.Utils.sleep;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class XPublisher implements Flow.Publisher<Integer> {

	private static RandomGenerator randomGenerator = RandomGenerator.of("SecureRandom");

	protected final IntStream intStream;
	private final SubmissionPublisher<Integer> submissionPublisher = new SubmissionPublisher<>();

	public XPublisher() {
		intStream = IntStream.generate(() -> randomGenerator.nextInt(100));
	}

	@Override
	public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
		submissionPublisher.subscribe(subscriber);
	}

	public void start() {
		intStream.forEach(element -> {
			System.out.println(element);
			submissionPublisher.submit(element);
			sleep(2000);
		});
	}
}
