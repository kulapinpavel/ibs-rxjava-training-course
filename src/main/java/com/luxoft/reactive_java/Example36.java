package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example36 {
    public static void main(String[] args) {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .any(s -> s.length() > 6)
                .subscribe(result -> System.out.println("Result: " + result));

    }

}