package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.Random;

public class Example08retry {
    public static void main(String[] args) {
        Random random = new Random();
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(1 / (random.nextBoolean() ? 1 : 0));
            o.onNext(1 / (random.nextBoolean() ? 1 : 0)); //TODO [vk] run several times
            o.onNext(1 / (random.nextBoolean() ? 1 : 0));
            o.onNext(1 / (random.nextBoolean() ? 1 : 0));
            o.onNext(1 / (random.nextBoolean() ? 1 : 0));
        });

        values
            .retry(2)
            .subscribe(v -> System.out.println(v),
                    e -> System.out.println("Error: "+e));

    }
}