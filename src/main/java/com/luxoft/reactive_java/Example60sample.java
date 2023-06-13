package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;
//TODO [vk] pic on slide is not very good!!! look at pic at method sample spec
public class Example60sample {
    public static void main(String[] args) throws InterruptedException {
        int[] delays = { 200, 1100, 1000, 200, 1400, 700 };
        Observable.range(0, delays.length)
                .map(i -> delays[i])
                .scan(Integer::sum)
                .flatMap(delay -> Observable.just(delay)
                    .delay(delay, TimeUnit.MILLISECONDS)
                    .doOnNext(System.out::println))
                .sample(1, TimeUnit.SECONDS)
                .subscribe(p -> System.out.println("sample "+p));
        Thread.sleep(5000);
    }
}