package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example31 {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .delay(2, TimeUnit.SECONDS)
                .subscribe(l -> System.out.println("Location: " + l));

        Thread.sleep(5000); // TODO [vk] зачем тут слип?
    }

}