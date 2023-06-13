package com.luxoft.reactive_java;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.UnicastSubject;

public class ExampleUnicastSubject {
    public static void main(String[] args)  {
        UnicastSubject<Integer> source = UnicastSubject.create();

        source.onNext(1);
        source.onNext(2);

        Disposable disposable = source.subscribe(v -> System.out.println("Observer 1: " + v));
        disposable.dispose();
        source.onNext(3);

        source.subscribe(v -> System.out.println("Observer 2: "+v),
                System.out::println);

        source.onNext(4);
        source.onComplete();
    }
}