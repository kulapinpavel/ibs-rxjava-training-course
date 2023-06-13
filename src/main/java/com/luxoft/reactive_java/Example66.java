package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

public class Example66 {

    @Test
    public void testObservable() {
        Observable<Integer> source = Observable.range(1, 5);
        TestObserver<Integer> testObserver = new TestObserver<>();
        testObserver.assertNotSubscribed();
        source.subscribe(testObserver);
        testObserver.assertSubscribed();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
        testObserver.assertValueCount(5);
        testObserver.assertValues(1, 2, 3, 4, 5);
    }

}