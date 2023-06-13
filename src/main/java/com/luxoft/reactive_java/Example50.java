package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;

public class Example50 {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .subscribeOn(Schedulers.computation())
                .map(s -> longTask(s))
                .subscribe(System.out::println);
        Observable.range(1, 5)
                .subscribeOn(Schedulers.computation())
                .map(i -> longTask(i))
                .subscribe(r -> System.out.println(r));
        System.out.println("before sleep");
        Thread.sleep(20000);
//                while (true);
        System.out.println("after sleep");
    }

    public static <T> T longTask(T value) throws InterruptedException {
        Thread.sleep(new Random().nextInt(2000));
        return value;
    }

}