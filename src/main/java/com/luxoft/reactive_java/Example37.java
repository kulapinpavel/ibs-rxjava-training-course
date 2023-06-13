package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example37 {
    public static void main(String[] args) {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia").
                        toList().
                        subscribe(list -> System.out.println(list));
    }
}