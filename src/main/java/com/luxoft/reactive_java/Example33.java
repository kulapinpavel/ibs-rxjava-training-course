package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example33 {
    public static void main(String[] args) {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .count()
                .subscribe(counter -> System.out.println("Counter: " + counter));

    }

}