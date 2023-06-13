package com.luxoft.reactive_java;

import io.reactivex.Completable;
import io.reactivex.Observable;

import java.io.IOException;

public class Example16onErrorComplete {
    public static void main(String[] args) {
        Completable.fromAction(() -> {
            throw new IOException();
        }).onErrorComplete(error -> {
            // Only ignore errors of type java.io.IOException.
            return error instanceof IOException;
        }).subscribe(
            () -> System.out.println("IOException was ignored"),
            error -> System.err.println("onError should not be printed!"));

    }
}