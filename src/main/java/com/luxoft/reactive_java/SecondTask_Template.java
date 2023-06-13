package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SecondTask_Template {

    private static final Observable<BigDecimal> transactions = Observable.create(
            (ObservableOnSubscribe<BigDecimal>) emitter -> {
                Thread.sleep(new Random().nextInt(2000));
                emitter.onNext(new BigDecimal("100"));
                Thread.sleep(new Random().nextInt(2000));
                emitter.onNext(new BigDecimal("1000"));
                Thread.sleep(new Random().nextInt(2000));
                emitter.onNext(new BigDecimal("-200"));
                Thread.sleep(new Random().nextInt(2000));
                emitter.onNext(new BigDecimal("-300"));
                Thread.sleep(new Random().nextInt(2000));
                emitter.onNext(new BigDecimal("1000"));
                Thread.sleep(new Random().nextInt(2000));
                emitter.onComplete();
            }).publish().refCount();

    private static final Observable<BigDecimal> cache = Observable.create(
            (ObservableOnSubscribe<BigDecimal>) emitter -> {
                Thread.sleep(new Random().nextInt(2000));
                emitter.onNext(new BigDecimal("1"));
                Thread.sleep(new Random().nextInt(2000));
                emitter.onNext(new BigDecimal("2"));
                Thread.sleep(new Random().nextInt(2000));
                emitter.onNext(new BigDecimal("-3"));
                Thread.sleep(new Random().nextInt(2000));
                emitter.onNext(new BigDecimal("-4"));
                Thread.sleep(new Random().nextInt(2000));
                emitter.onComplete();
            }).publish().refCount();

    //------ все 12 подзадач для Задания 2 ---------------
    public static void main(String[] args) throws InterruptedException {
//        first();
//        second();
//        third();
//        forth();
//        fifth();
//        sixth();
//        seventh();
        eighth();
//        ninth();
//        tenth();
//        eleventh();
//        twelfth();
    }

    // С помощью groupBy() показать по-отдельности все депозиты и все снятия
    private static void first() {
        // можно ли сделать с flatMapSingle?
        transactions.groupBy(bigDecimal -> bigDecimal.compareTo(new BigDecimal(0)))
                .subscribe(group -> {
                    group.toList().subscribe(operationsList -> {
                        System.out.println(
                                ((group.getKey() > 0) ? "Deposites: " : "Credites: ") + operationsList
                        );
                    });
                });
    }

    // С помощью scan() показать динамику текущего состояния счета
    private static void second() {
        transactions.scan(BigDecimal::add)
                .subscribe(System.out::println);
    }

    // С помощью timestamp() показать момент исполнения операции
    private static void third() {
        transactions.timestamp()
                .subscribe(timedOperation -> System.out.println(
                        Instant.ofEpochMilli(timedOperation.time()) + ": " + timedOperation.value().toString())
                );
    }

    // С помощью count() вычислить кол-во депозитов и снятий
    private static void forth() {
        transactions.groupBy(bigDecimal -> isDeposite(bigDecimal))
                .subscribe(group -> {
                    group.count().subscribe(operationsCount -> {
                        System.out.println(
                                (Boolean.TRUE.equals(group.getKey()) ? "Deposites: " : "Credites: ") + operationsCount
                        );
                    });
                });
    }

    // Получить мультимапу, где хранятся все депозиты и снятия
    private static void fifth() {
        transactions.toMultimap(bigDecimal -> isDeposite(bigDecimal) ? "Deposites" : "Credites")
                .subscribe(System.out::println);
    }

    private static boolean isDeposite(BigDecimal bigDecimal) {
        return bigDecimal.compareTo(new BigDecimal(0)) > 0;
    }

    // Создать еще один Observable, эмиттирующий банковские операции, и слить его эмиссию
    // с первым обзерваблом; показать все операции
    private static void sixth() {
        final Observable<BigDecimal> yetAnotherObservable = Observable.create(
                (ObservableOnSubscribe<BigDecimal>) emitter -> {
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("400"));
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("-600"));
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("100"));
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onComplete();
                }).publish().refCount();

        Observable.merge(transactions, yetAnotherObservable).subscribe(System.out::println);
    }

    // Создать метод Observable<String> remoteProcess(int amount), который будет «обрабатывать»
    // каждую операцию, беря ее в круглые скобки (т.е., (100) (200) и т.д.).
    // Предусмотреть задержки, которые имитируют отработку на удаленном сервере.
    // Применить этот метод ко всем операциям (подсказка: взять flatMap()).
    private static void seventh() {
        transactions.flatMap(operation -> remoteProcess(operation.intValue()))
                .subscribe(System.out::println);
    }

    private static Observable<String> remoteProcess(int amount) {
        return Observable.just("(" + amount + ")").delay(1000, TimeUnit.MILLISECONDS);
    }

    // Создать отдельный Observable с подтверждениями (напр., [ true, true, false, true ]).
    // Затем с помощью zip() скомбинировать его элементы с операциями так, чтобы подавить все
    // неподтвержденные заявки.
    private static void eighth() {
        final Observable<Boolean> approvals = Observable.create(
                (ObservableOnSubscribe<Boolean>) emitter -> {
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(Boolean.TRUE);
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(Boolean.TRUE);
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(Boolean.FALSE);
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(Boolean.TRUE);
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onComplete();
                }).publish().refCount();

        Observable.zip(transactions, approvals, (bigDecimal, aBoolean) -> aBoolean ? Observable.just(bigDecimal) : Observable.empty())
                .flatMap(o -> o)
                .subscribe(System.out::println);
    }

    // Создать Observable со сведениями о клиенте, напр. [“Ivan”, “Maria”];
    // С помощью combineLatest() добавить эту информацию к банковской операции.
    // Предусмотреть задержку перед сменой клиента.
    private static void ninth() throws InterruptedException {
        final Observable<String> clients = Observable.create(
                (ObservableOnSubscribe<String>) emitter -> {
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext("Ivan");
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext("Maria");
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext("Ivan");
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext("Maria");
                    emitter.onComplete();
                }).publish().refCount();

        final Observable<BigDecimal> localCache = Observable.create(
                (ObservableOnSubscribe<BigDecimal>) emitter -> {
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("1"));
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("2"));
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("-3"));
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("-4"));
                    emitter.onComplete();
                }).subscribeOn(Schedulers.computation()).publish().refCount();

        throw new RuntimeException("Not implemented");
    }

    // С помощью replay() заново "проиграть" предыдущие операции, когда подписчик запоздал.
    // Другими словами, добавить задержку и затем подключить 2-го подписчика, после чего
    // убедиться, что он действительно получил сообщения в полном объеме.
    private static void tenth() throws InterruptedException {
        final ConnectableObservable<BigDecimal> localCache = Observable.create(
                (ObservableOnSubscribe<BigDecimal>) emitter -> {
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("1"));
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("2"));
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("-3"));
                    Thread.sleep(new Random().nextInt(2000));
                    emitter.onNext(new BigDecimal("-4"));
                    emitter.onComplete();
                }).replay();

        throw new RuntimeException("Not implemented");
    }

    // Превратить Observable в PublishSubject и удостовериться, что он действительно
    // способен выполнять банковские операции
    private static void eleventh() {
        throw new RuntimeException("Not implemented");
    }

    // С помощью ReplaySubject воспроизвести все операции для припозднившихся подписчиков.
    private static void twelfth() {
        throw new RuntimeException("Not implemented");
    }
}
