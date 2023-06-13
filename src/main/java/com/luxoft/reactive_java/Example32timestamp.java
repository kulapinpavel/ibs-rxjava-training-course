package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Example32timestamp {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
            .take(3)
            .timestamp()
            .blockingSubscribe(val -> {
                System.out.println(Instant.ofEpochMilli(val.time()));
                System.out.println(val.value());
            });
    }

}