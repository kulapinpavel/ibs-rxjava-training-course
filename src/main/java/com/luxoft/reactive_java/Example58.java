package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example58 { //TODO [vk] run several times to demo corner cases
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300)
                .buffer(900, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
        Thread.sleep(5000);
    }
}