package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example48 {
    public static void main(String[] args) throws InterruptedException {
        // replay().autoConnect() is the same as .cache()
        // replay() has more parameters (like time to cache) and flexibility
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .replay(2, TimeUnit.SECONDS)
                        .autoConnect();

        seconds.subscribe(i -> System.out.println("Received 1: " + i));
        Thread.sleep(3000);

        seconds.subscribe(i -> System.out.println("Received 2: " + i));

        Thread.sleep(3000);
    }
}