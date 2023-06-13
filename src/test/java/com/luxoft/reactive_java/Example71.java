package com.luxoft.reactive_java;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example71 {

    @Test
    public void testStepVerifierMonoException() {
        Mono<String> monoException = Mono.error(new RuntimeException("exception"));

        StepVerifier.create(monoException)
                .expectErrorMessage("exception")
                .verify();
    }

    @Test
    public void testStepVerifierMonoMessage() {
        Mono<String> message = Mono.just("message");
        StepVerifier.create(message)
                .expectNext("message")
                .verifyComplete();
    }

    @Test
    public void testStepVerifierFlux() {
        Flux<Integer> flux = Flux.just(1, 2, 3);

        StepVerifier.create(flux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectComplete()
                .verify(Duration.ofSeconds(10));
    }

    @Test
    public void testTestPublisher() {
        TestPublisher<Object> publisher = TestPublisher.create();
        Flux<Object> stringFlux = publisher.flux();
        List list = new ArrayList();

        stringFlux.subscribe(next -> list.add(next), ex -> ex.printStackTrace());
        publisher.emit("one", "two");

        assertEquals(2, list.size());
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
    }
}
