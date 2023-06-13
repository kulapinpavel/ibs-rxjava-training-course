package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example19 {
    public static void main(String[] args) {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .filter(s -> s.length() >= 5)
                .subscribe(s -> System.out.println("Location: " + s));
    }

}