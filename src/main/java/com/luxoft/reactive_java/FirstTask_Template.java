package com.luxoft.reactive_java;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

import java.math.BigDecimal;
import java.util.Random;

public class FirstTask_Template {

    // это всего лишь вспомогательный метод
    private static Observable<BigDecimal> getTXs(){
        return Observable.create(
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
                    emitter.onComplete();
                }).publish().refCount();
    }
    public static void main(String[] args) throws InterruptedException {
        //------ все 12 подзадач для Задания 1 ---------------
//        first();
//        second();
//        third();
//        forth();
//        fifth();
//        sixth();
//        seventh();
//        eighth();
//        ninth();
//        tenth();
//        eleventh();
//        twelfth();
    }

//    Создать Observable, который эмиттирует операции на банковском счете (депозиты и снятие средств,
//    а именно: [+100, +1000, -200, -300]) со случайными интервалами;
//    подсказка: понадобятся create(), onNext() и Thread.sleep() для задержек.
    private static void first() {
        throw new RuntimeException("Not implemented");
    }

//    Аналогично подзадаче 1, но заодно использовать filter(), чтобы показать только депозиты.
    private static void second() {
        throw new RuntimeException("Not implemented");
    }

//    Аналогично подзадаче 1, но заодно использовать map(), чтобы преобразовать суммы в центы (или копейки).
    private static void third() {
        throw new RuntimeException("Not implemented");
    }

//    Создать Observable и бросить ошибку с помощью onError(), а также вывести сведения об ошибке,
//    подписавшись на onError-событие.
    private static void forth() {
        throw new RuntimeException("Not implemented");
    }

//    Аналогично подзадаче 1, но заодно добавить обработчики onError и onComplete в описание метода subscribe().
    private static void fifth() {
        throw new RuntimeException("Not implemented");
    }

//    Использовать Disposable для отмены подписки на Observable после некоторой задержки и убедиться,
//    что сообщения действительно перестали приходить.
    private static void sixth() throws InterruptedException {
        throw new RuntimeException("Not implemented");
    }

//    Использовать методы с побочным эффектом для печати элементов до фильтрации, между фильтрацией и отображением,
//    а также в случае ошибки; подсказка: понадобятся doOnNext(), doOnError().
    private static void seventh() {
        throw new RuntimeException("Not implemented");
    }

//    В случае ошибки заменить ее на 0 (понадобится onErrorReturn()).
    private static void eighth() {
        throw new RuntimeException("Not implemented");
    }

//    Превратить Observable в расшаренный источник и подписать на него несколько обзерверов.
    private static void ninth() throws InterruptedException{
        throw new RuntimeException("Not implemented");
    }

//    Превратить Observable в connectable, подписать на него несколько обзерверов
//    и вызвать на нем connect() после некоторой задержки.
    private static void tenth() throws InterruptedException {
        throw new RuntimeException("Not implemented");
    }

//    Отложить создание Observable с помощью defer() и сделать паузу перед подпиской.
    private static void eleventh() throws InterruptedException {
        throw new RuntimeException("Not implemented");
    }

//    Сделать композит из Disposables и затем утилизировать их одним махом.
    private static void twelfth() throws InterruptedException {
        throw new RuntimeException("Not implemented");
    }

}
