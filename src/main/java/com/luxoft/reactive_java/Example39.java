package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example39 {
    public static void main(String[] args) {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia").
                        toMap(s->s.charAt(0)).
                        subscribe(map -> System.out.println(map));
    }
}