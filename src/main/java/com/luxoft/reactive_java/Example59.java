package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example59 {
    public static void main(String[] args) {
        Observable.range(1, 50)
                .window(16)
                .flatMapSingle(obs -> obs.reduce("", (total,
                                                      next) -> total
                        + (total.equals("") ? "" : "|") + next))
                .subscribe(System.out::println);
    }
}