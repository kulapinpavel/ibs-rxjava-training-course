package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example55 {
    public static void main(String[] args) {
        ExecutorService executor =
                Executors.newFixedThreadPool(2);
        Scheduler scheduler = Schedulers.from(executor);

        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .subscribeOn(scheduler)
                .subscribe(i -> System.out.println("Received " + i
                        + " on thread " + Thread.currentThread().getName()));
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .subscribeOn(scheduler)
                .subscribe(i -> System.out.println("Received " + i
                        + " on thread " + Thread.currentThread().getName()));
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .subscribeOn(scheduler)
                .subscribe(i -> System.out.println("Received " + i
                        + " on thread " + Thread.currentThread().getName()));
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .subscribeOn(scheduler)
                .subscribe(i -> System.out.println("Received " + i
                        + " on thread " + Thread.currentThread().getName()));
        System.out.println("the end"); //TODO [vk] why so?
    }

}