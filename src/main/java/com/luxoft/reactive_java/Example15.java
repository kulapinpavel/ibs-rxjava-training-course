package com.luxoft.reactive_java;

import io.reactivex.Maybe;

public class Example15 {

    public static void main(String[] args) {
        Maybe<String> justSource = Maybe.just("Bucharest");
        justSource.subscribe(s -> System.out.println("Receiver 1: " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Done 1"));

        Maybe<String> emptySource = Maybe.empty();
        emptySource.subscribe(s -> System.out.println("Receiver 2: " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Done 2"));
    }
}