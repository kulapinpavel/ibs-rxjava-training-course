package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Example54 {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS,
                Schedulers.single())
                .subscribe(i -> System.out.println("Received " + i
                        + " on thread " + Thread.currentThread().getName()));
        Thread.sleep(5000);
    }

}