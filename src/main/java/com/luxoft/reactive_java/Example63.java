package com.luxoft.reactive_java;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Example63 {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("rx2.buffer-size", "16");
        Flowable.range(1, 1_000_000)
//                .onBackpressureDrop(dropped -> System.out.println("dropped "+dropped))
                .onBackpressureDrop()
                .map(Counter::new)
                .observeOn(Schedulers.io(), false, 10)
                .subscribe(counter -> {
                    Thread.sleep(1);
                    System.out.println("Received " + counter.count);
                }, Throwable::printStackTrace);
        Thread.sleep(20000);
    }

    static final class Counter {
        int count;

        Counter(int count) {
            this.count = count;
            System.out.println("Creating " + count);
        }
    }
}