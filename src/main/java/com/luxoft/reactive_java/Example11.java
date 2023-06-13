package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Example11 {
    public static void main(String[] args) {
        ConnectableObservable<String> locations =
                Observable.just("Bucharest", "Krakow", "Moscow", "Kiev",
                        "Sofia").publish();
        locations.subscribe(s ->
                System.out.println("Locations for observer 1: " + s));
        locations.map(String::length)
                .subscribe(l ->
                System.out.println("Lengths for observer 2: " + l));
        locations.map(String::length)
                .filter(l -> l >=5)
                .subscribe(l ->
                        System.out.println("Filtered lengths " +
                                "for observer 3: " + l));

        locations.connect();
    }
}