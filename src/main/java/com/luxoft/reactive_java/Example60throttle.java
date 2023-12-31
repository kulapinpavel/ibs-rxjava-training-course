package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example60throttle {
    public static void main(String[] args) throws InterruptedException {
        int[] delays = { 200, 1100, 1000,  200, 1400, 700 };
        Observable.range(0, delays.length)
                .map(i -> delays[i])
                .scan(Integer::sum)
                .flatMap(delay -> Observable.just(delay)
                    .delay(delay, TimeUnit.MILLISECONDS)
                    .doOnNext(System.out::println))
                .throttleWithTimeout(1, TimeUnit.SECONDS) // TODO [vk] what's the diff with debounce?
                .subscribe(p -> System.out.println("throttle "+p));
        Thread.sleep(5000);
    }
}