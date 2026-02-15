package reactivedemo;

import static reactivedemo.Utils.sleep;

import java.util.concurrent.Flow;

public class SlowPowerRaiseProcessor implements Flow.Processor<Integer, Integer> {

	private Flow.Subscription subscription;

	@Override
	public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
	}

	@Override
	public void onSubscribe(Flow.Subscription subscription) {
		if (this.subscription == null) {
			System.out.println("PowerRaiseProcessor.onSubscribe (==null)");
			this.subscription = subscription;
			this.subscription.request(1);
		} else {
			System.out.println("PowerRaiseProcessor.onSubscribe (subscription.cancel())");
			subscription.cancel();
		}
	}

	@Override
	public void onNext(Integer integer) {
		System.out.println("              " + "              " + "              " + integer + "*" + integer + "=" + integer * integer);
		sleep(3000);
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {

	}

	@Override
	public void onComplete() {

	}
}
