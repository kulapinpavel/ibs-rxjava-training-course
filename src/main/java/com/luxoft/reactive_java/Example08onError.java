package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.io.IOException;

public class Example08onError {
    public static void main(String[] args) {
        Observable.error(new IOException("Something went wrong"))
            .doOnError(error ->
                    System.err.println("The error message is: " + error.getMessage()))
            .subscribe(
                x -> System.out.println("onNext should never be printed!"),
                Throwable::printStackTrace,
                () -> System.out.println("onComplete should never be printed!"));

    }
}