package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example26 {
    public static void main(String[] args) {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .elementAt(2)
                .subscribe(s -> System.out.println("Location: " + s));
    }

}