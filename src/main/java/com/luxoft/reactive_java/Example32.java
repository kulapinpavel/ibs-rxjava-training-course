package com.luxoft.reactive_java;

import io.reactivex.Observable;

public class Example32 {
    public static void main(String[] args) {
        Observable.range(1, 10)
                  .scan((x, y) -> x+y)
                  .subscribe(sum -> System.out.println("Sum: " + sum));
    }

}