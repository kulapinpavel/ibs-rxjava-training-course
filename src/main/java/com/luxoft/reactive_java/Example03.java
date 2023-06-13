package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example03 {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> steps =
                Observable.interval(1, TimeUnit.SECONDS);
        steps.subscribe(l -> System.out.println(l));
        //TODO
        // steps.subscribe(l -> System.out.println(l + " " + Thread.currentThread().getName()));
        Thread.sleep(10000); //TODO [vk] зачем тут sleep?
    }

}