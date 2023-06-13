package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example60 {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300) // map to elapsed time
                .window(1, TimeUnit.SECONDS)
                .flatMapSingle(obs -> obs.reduce("", (total,
                                                      next) -> total
                        + (total.equals("") ? "" : "|") + next))
                .subscribe(System.out::println);
        Thread.sleep(5000);
    }
}