package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example10 {
    public static void main(String[] args) {
        Observable<String> locations =
                Observable.just("Bucharest", "Krakow", "Moscow", "Kiev",
                        "Sofia");
        locations.subscribe(s -> System.out.println("Location for observer 1: " + s));
        locations.map(String::length).filter(l -> l >= 5)
                .subscribe(l -> System.out.println("Length for observer 2: " + l));
    }
}