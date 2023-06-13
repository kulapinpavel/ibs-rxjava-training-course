package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;

public class Example52 {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                          .subscribeOn(Schedulers.computation())
                          .map(s -> longTask((s)))
                          .blockingSubscribe(r -> System.out.println(r));
    }

    public static <T> T longTask(T value) throws InterruptedException {
        Thread.sleep(new Random().nextInt(2000));
        return value;
    }

}