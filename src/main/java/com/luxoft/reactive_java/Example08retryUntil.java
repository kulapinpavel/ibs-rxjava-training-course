package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

//TODO [vk] run several times
public class Example08retryUntil {
    public static void main(String[] args) {
        Random random = new Random();
        LongAdder errorCounter = new LongAdder();

        Observable<Integer> source = Observable.create(o -> {
            o.onNext(1 / (random.nextBoolean() ? 1 : 0));
        });

        source.doOnError((error) -> {
            errorCounter.increment();
            System.out.println("errorCounter "+errorCounter.intValue());
        })
        .retryUntil(() -> errorCounter.intValue() >= 2)
            .subscribe(
                x -> System.out.println("onNext: " + x),
                error -> System.err.println(
                        "onError: " + error.getMessage()));

    }
}