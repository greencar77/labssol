package reactivedemo;

import java.util.concurrent.Flow;

import org.junit.jupiter.api.Test;

public class MainTest {

	@Test
	public void test() {
		//1) setup publisher
		XPublisher publisher = new XPublisher();

		//2) setup processors
		Flow.Processor<Integer, Integer> powerRaiseProcessor = new PowerRaiseProcessor();
		publisher.subscribe(powerRaiseProcessor);
//		publisher.subscribe(powerRaiseProcessor);

		Flow.Processor<Integer, Integer> negativeProcessor = new NegativeProcessor();
		publisher.subscribe(negativeProcessor);

		Flow.Processor<Integer, Integer> slowPowerRaiseProcessor = new SlowPowerRaiseProcessor();
		publisher.subscribe(slowPowerRaiseProcessor);

 		//3) start
		publisher.start();
	}
}