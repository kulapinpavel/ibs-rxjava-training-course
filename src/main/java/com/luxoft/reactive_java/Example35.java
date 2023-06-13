package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example35 {
    public static void main(String[] args) {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .all(s -> s.length() > 3)
                .subscribe(result -> System.out.println("Result: " + result));

    }

}