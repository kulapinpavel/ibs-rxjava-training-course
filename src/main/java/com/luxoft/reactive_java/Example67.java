package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Example67 {

    @Test
    public void testObservable() {
        TestScheduler testScheduler = new TestScheduler();
        TestObserver<Long> testObserver = new TestObserver<>();
        Observable<Long> minuteTicker =
                Observable.interval(1, TimeUnit.MINUTES,
                        testScheduler);
        minuteTicker.subscribe(testObserver);
        testScheduler.advanceTimeBy(30, TimeUnit.SECONDS);
        testObserver.assertValueCount(0);
        testScheduler.advanceTimeTo(70, TimeUnit.SECONDS);
        testObserver.assertValueCount(1);
        testScheduler.advanceTimeTo(90, TimeUnit.MINUTES);
        testObserver.assertValueCount(90);

    }

}