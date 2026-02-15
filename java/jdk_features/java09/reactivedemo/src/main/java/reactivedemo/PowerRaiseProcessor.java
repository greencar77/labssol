package reactivedemo;

import static reactivedemo.Utils.sleep;

import java.util.concurrent.Flow;

public class PowerRaiseProcessor implements Flow.Processor<Integer, Integer> {

	private Flow.Subscription subscription;

	@Override
	public void subscribe(Flow.Subscriber<? super Integer> subscriber) {

	}

	@Override
	public void onSubscribe(Flow.Subscription subscription) {
		if (this.subscription == null) {
			System.out.println("PowerRaiseProcessor.onSubscribe (==null)");
			this.subscription = subscription;
			// apply back pressure - request one element
			this.subscription.request(1);
		} else {
			System.out.println("PowerRaiseProcessor.onSubscribe (subscription.cancel())");
			subscription.cancel();
		}
	}

	@Override
	public void onNext(Integer integer) {
		System.out.println("              " + integer + "*" + integer + "=" + integer * integer);
		subscription.request(1);
//		sleep(5000);
//		System.out.println("              " + integer + "*" + integer + "=" + integer * integer + " END");
	}

	@Override
	public void onError(Throwable throwable) {
	}

	@Override
	public void onComplete() {
	}
}
