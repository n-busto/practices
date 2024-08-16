package com.nbusto.java.rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class HotAndCold {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("COLD -----------------");
        coldObservable();
        System.out.println("HOT  -----------------");
        hotObservable();
    }

    private static void coldObservable() {
        final var observable = Observable.just("a", "b", "c");

        observable.subscribe(it -> System.out.println("Observer 1 - " + it)).dispose();
        observable.subscribe(it -> System.out.println("Observer 2 - " + it)).dispose();
        observable.subscribe(it -> System.out.println("Observer 3 - " + it)).dispose();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void hotObservable() throws InterruptedException {
        final var observable = Observable.interval(1, TimeUnit.SECONDS).publish();

        observable.connect();

        observable.subscribe(it -> System.out.println("Observer 1 - " + it));

        Thread.sleep(5000);
        observable.subscribe(it -> System.out.println("Observer 2 - " + it));

        Thread.sleep(10000);
    }

}
