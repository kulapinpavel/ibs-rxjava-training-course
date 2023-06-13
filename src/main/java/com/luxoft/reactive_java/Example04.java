package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example04 {
    public static void main(String[] args) {
        Observable<String> locations = Observable.create(location -> {
            location.onNext("Bucharest");
            Thread.sleep(2000);
            location.onNext("Krakow");
            Thread.sleep(2000);
            location.onNext("Moscow");
            Thread.sleep(2000);
            location.onNext("Kiev");
            Thread.sleep(2000);
            location.onNext("Sofia");
            location.onComplete();
        });
        locations.subscribe(s -> System.out.println("Location: " + s));
    }
}