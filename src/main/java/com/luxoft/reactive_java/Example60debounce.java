package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;
//TODO [vk] pic on slide is not very good!!! look at pic at method debounce spec
public class Example60debounce {
    public static void main(String[] args) throws InterruptedException {
        int[] delays = { 200, 1100, 1000, 200, 1400, 700 }; //ToDO [vk] run several times to demo corner case
        Observable.range(0, delays.length)
                .map(i -> delays[i])
                .scan(Integer::sum)
                .flatMap(delay -> Observable.just(delay)
                    .delay(delay, TimeUnit.MILLISECONDS)
                    .doOnNext(System.out::println))
                .debounce(1, TimeUnit.SECONDS)
                .subscribe(p -> System.out.println("debounced "+p));
        Thread.sleep(5000);
    }
}