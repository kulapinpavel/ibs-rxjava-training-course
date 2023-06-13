package com.luxoft.reactive_java;

import io.reactivex.Completable;

public class Example16 {
    public static void main(String[] args) {
        Completable.fromRunnable(() -> execute())
                .subscribe(() -> System.out.println("finish"));
    }

    public static void execute() {
        System.out.println("execute");
    }
}