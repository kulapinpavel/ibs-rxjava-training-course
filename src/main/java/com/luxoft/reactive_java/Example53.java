package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example53 {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS,
                Schedulers.newThread())
                .subscribe(i -> System.out.println("Received " + i
                        + " on thread " + Thread.currentThread().getName()));
        Observable.interval(1, TimeUnit.SECONDS,
                Schedulers.newThread())
                .subscribe(i -> System.out.println("Received " + i
                        + " on thread " + Thread.currentThread().getName()));
        System.out.println("main thread");
        Thread.sleep(5000);
    }

}