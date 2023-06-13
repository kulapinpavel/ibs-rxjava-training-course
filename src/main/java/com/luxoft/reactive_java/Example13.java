package com.luxoft.reactive_java;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Example13 {
    private static int start = 1;
    private static int count = 3;

    public static void main(String[] args) {
        Observable<Integer> source = Observable.defer(() -> //TODO [vk] defer makes great difference!
                Observable.range(start, count));
        source.subscribe(i -> System.out.println("Observer 1: " + i));

        start = 4;
        count = 5;
        source.subscribe(i -> System.out.println("Observer 2: " + i));
    }
}