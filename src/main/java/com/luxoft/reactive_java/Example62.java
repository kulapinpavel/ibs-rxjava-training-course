package com.luxoft.reactive_java;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Example62 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("rx2.buffer-size", "16");
        Flowable.range(1, 1_000_000)
                .onBackpressureBuffer(100000, false, true)
//                .doOnNext(i -> System.out.println("before observe " + Thread.currentThread().getName()))
                .observeOn(Schedulers.io(), false, 10)// we are able to change the size of buffer
//                .doOnNext(i -> System.out.println("after observe " + Thread.currentThread().getName()))
                .map(Counter::new)
//                .subscribeOn(Schedulers.single())
                .subscribe(counter -> {
                    Thread.sleep(100);
                    System.out.println("Received " + counter.count);
//                    System.out.println("Received " + counter.count + " | " + Thread.currentThread().getName());
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