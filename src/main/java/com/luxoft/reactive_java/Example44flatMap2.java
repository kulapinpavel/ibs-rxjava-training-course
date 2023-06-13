package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example44flatMap2 {
    static long delay = 1000;
    public static Observable<String> remoteRequest(String s) {
        delay -= 100;
        return Observable.just("("+s+") ("+delay+")")
                .delay(delay, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        Observable<String> locations =
                Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia");
        locations
                .doOnNext(s -> System.out.println("sent to remote: "+s))
                .flatMap(s -> remoteRequest(s))
                .blockingSubscribe(System.out::println);
    }
}