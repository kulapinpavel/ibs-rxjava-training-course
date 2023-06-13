package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class Example02 {
    public static void main(String[] args) {
        Observable<String> locations =
                Observable.just("Bucharest", "Krakow", "Moscow", "Kiev",
                        "Sofia");
        locations
                .map(String::length)
                .subscribe(l -> System.out.println(l));
//TODO [vk]
//        .subscribe(l -> System.out.println(l + " " + Thread.currentThread().getName()));
    }
}