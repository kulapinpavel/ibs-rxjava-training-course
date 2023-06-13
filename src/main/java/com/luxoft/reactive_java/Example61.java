package com.luxoft.reactive_java;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscription;

public class Example61 {
    public static void main(String[] args) throws InterruptedException {
        // Observable would buffer as much elements as fit in memory
        // Flowable implements backpressure strategy (buffer by default)
        Flowable.range(1, 1_000_000)
                .map(Counter::new)
                .observeOn(Schedulers.io())
                .subscribe(counter -> {
                    Thread.sleep(100);
                    System.out.println("Received " + counter.count);
                }, Throwable::printStackTrace);
        Thread.sleep(30000);

    }

    static final class Counter {
        int count;

        Counter(int count) {
            this.count = count;
            System.out.println("Creating " + count);
        }
    }
}