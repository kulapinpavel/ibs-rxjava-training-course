package com.luxoft.reactive_java;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;

public class ExampleBehaviorSubject {
    public static void main(String[] args) {
        BehaviorSubject<Integer> source = BehaviorSubject.create();

        source.subscribe(v -> System.out.println("Observer 1: "+v));

        source.onNext(1);
        source.onNext(2);
        source.onNext(3);

        source.subscribe(v -> System.out.println("Observer 2: "+v));

        source.onNext(4);
        source.onComplete();
    }
}