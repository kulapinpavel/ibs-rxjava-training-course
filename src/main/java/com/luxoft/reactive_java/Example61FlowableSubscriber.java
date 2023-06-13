package com.luxoft.reactive_java;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Example61FlowableSubscriber {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> range = Flowable.range(1, 1_000_000);
        range
                .map(Counter::new)
//                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Counter>() {

                    Subscription sub;

                    @Override
                    public void onSubscribe(@NonNull Subscription s) {
                        sub = s;
                        sub.request(10);
                    }

                    @Override
                    public void onNext(Counter counter) {
                        System.out.println(counter.count);
//                        sub.request(1);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    static final class Counter {
        int count;

        Counter(int count) {
            this.count = count;
            System.out.println("Creating " + count);
        }
    }
}