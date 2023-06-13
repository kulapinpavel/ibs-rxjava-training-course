package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;
public class Example45switchMap {
    public static Observable<String> remoteRequest(String s) {
        return Observable.just("("+s+")")
                .delay(1, TimeUnit.SECONDS);
    }
    /**
     *  sent                  received
        200     Bucharest ->  1200
        2300    Krakow ->     3300
        3800    Moscow ->     4800   : 4800>4000
        4000    Kiev ->       5000
        4100    Sofia ->      5100
     */
    public static void main(String[] args) {
        Observable<String> locations = Observable
                .just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia");
        locations.zipWith(
            Observable.fromArray(200, 2100, 1500, 200, 100) // delays
            .scan(Integer::sum)
            .doOnNext(delay -> System.out.println("doOnNext: " + delay))
            .delay(delay -> Observable.timer(delay, TimeUnit.MILLISECONDS)),
                (location, interval) -> interval + " " + location
        )
        .switchMap(s -> remoteRequest(s)) //TODO [vk] см картинку в спеке метода switchMap - она более наглядная
        .blockingSubscribe(System.out::println);
    }
}