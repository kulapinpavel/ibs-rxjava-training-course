package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example34 {
    public static void main(String[] args) {
        Observable.range(1, 10)
                .reduce((total, next) -> total + next)
                .subscribe(total -> System.out.println("Total: " + total));

    }

}