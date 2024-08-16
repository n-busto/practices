package com.nbusto.java.rx;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static java.lang.Thread.sleep;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class Asynchrony {

    private final static int COUNT = 100;
    private final static int SLEEP_MILLISECONDS = 100;

    public static void main(String[] args) {
        asynchronousObservableExample();
        asynchronousFlowableExample();
        synchronousObservableExample();
    }

    private static void synchronousObservableExample() {
        Observable.range(1, COUNT)
                .map(it -> new Item("SyncObs", it))
                .subscribe(Asynchrony::printItem);
    }

    private static void asynchronousObservableExample() {
        Observable.range(1, COUNT)
                .map(it -> new Item("AsyncObs", it))
                .observeOn(Schedulers.io())
                .subscribe(Asynchrony::printItem);
    }

    private static void asynchronousFlowableExample() {
        Flowable.range(1, COUNT)
                .map(it -> new Item("AsyncFlow", it))
                .observeOn(Schedulers.io())
                .subscribe(Asynchrony::printItem);
    }

    private static void printItem(Item item) throws InterruptedException {
        sleep(SLEEP_MILLISECONDS);
        System.out.println(item);
    }

    private record Item(String flow, int number) {
    }
}
