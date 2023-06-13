package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class Example48replay {
    public static void main(String[] args) throws InterruptedException {
        ConnectableObservable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .replay();

        seconds.subscribe(i -> System.out.println("Received 1: " + i));
        Thread.sleep(3000);

        seconds.subscribe(i -> System.out.println("Received 2: " + i));

        seconds.connect();
        Thread.sleep(3000);
        seconds.subscribe(i -> System.out.println("Received 3: " + i));
        Thread.sleep(3000);
    }
}