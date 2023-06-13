package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class Example11share {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> obs =
                Observable.interval(1,
                    TimeUnit.SECONDS)
                    .doOnNext(v->
                            System.out.println("Generated: "+v))
                    .share();

        Thread.sleep(5000);
        Disposable sub1 = obs.subscribe(s ->
                System.out.println("Observer 1: " + s));
        Thread.sleep(5000);
        Disposable sub2 = obs.subscribe(l ->
                System.out.println("Observer 2: " + l));

        Thread.sleep(3000);
        sub1.dispose();
        System.out.println("Observer 1 disposed...");
        Thread.sleep(3000);
        sub2.dispose();
        System.out.println("Observer 2 disposed...");
        Thread.sleep(3000);
        System.out.println("Finished.");

    }
}