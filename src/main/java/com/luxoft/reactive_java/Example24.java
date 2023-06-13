package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example24 {
    public static void main(String[] args) {
        Observable.just("Bucharest", "Krakow", "Moscow", "Krakow", "Moscow", "Kiev", "Sofia")
                .distinct()
                .subscribe(s -> System.out.println("Location: " + s));
    }

}