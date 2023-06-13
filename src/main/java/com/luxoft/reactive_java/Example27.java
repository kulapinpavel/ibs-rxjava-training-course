package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example27 {
    public static void main(String[] args) {
        Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia")
                .map(s->s.length())
                .subscribe(l -> System.out.println("Length: " + l));
    }

}