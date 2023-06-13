package com.luxoft.reactive_java;

import io.reactivex.Completable;
import io.reactivex.Observable;

import java.io.IOException;

public class Example08onErrorResume {
    public static void main(String[] args) {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(1);
            o.onNext(2);
            o.onError(new Exception("Oops"));
            o.onNext(3);
        });

        values
            .onErrorResumeNext(Observable.just(6,6,6))
            .subscribe(s-> System.out.println("next: "+s));

    }
}