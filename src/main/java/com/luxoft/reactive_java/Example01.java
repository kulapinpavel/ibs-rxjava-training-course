package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example01 {
    public static void main(String[] args) {
        Observable<String> locations =
                Observable.just("Bucharest", "Krakow", "Moscow", "Kiev",
                        "Sofia");
        locations.subscribe(s -> System.out.println(s)); //TODO [vk] кто тут Observer?
    }
}