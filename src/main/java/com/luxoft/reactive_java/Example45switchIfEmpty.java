package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.concurrent.TimeUnit;

public class Example45switchIfEmpty {
    public static Observable<String> fromCache() {
        return Observable.<String>empty();
    }
    public static Observable<String> errorIfEmpty() {
        return Observable.error(new Exception("no data!"));
    }
    public static Observable<String> fromNetwork() {
        return Observable.just("this", "is", "from", "network");
    }

    public static void main(String[] args) throws InterruptedException {
        // Case 1. If no info in cache, take it from network
        Observable.defer(() -> fromCache())
        .switchIfEmpty(fromNetwork())
        .subscribe(System.out::println);

        System.out.println();
        // Case 2. If no info in cache, throw error
        Observable.defer(() -> fromCache())
                .switchIfEmpty(errorIfEmpty())
                .subscribe(System.out::println,
                        err -> System.out.println(
                                "ERROR: " + err));
        Thread.sleep(1000); // TODO [vk] зачем тут слип?
    }
}