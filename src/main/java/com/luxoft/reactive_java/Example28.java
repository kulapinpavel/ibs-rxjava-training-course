package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example28 {
    public static void main(String[] args) {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .startWith("Berlin")
                .subscribe(l -> System.out.println("Location: " + l));
    }

}