package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example57 {
    public static void main(String[] args) {
        Observable.range(1,100)
                .buffer(16)
                .subscribe(System.out::println);
    }
}