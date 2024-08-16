package com.nbusto.java.rx;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class Disposable {

    public static void main(String[] args) {
        disposableExample1();
        disposableExample2();
        disposableExample3();
    }

    private static void disposableExample1() {
        final var seconds = Observable
                .interval(1, TimeUnit.SECONDS);

        final var disposable = seconds
                .subscribe(System.out::println);

        if (disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private static void disposableExample2() {
        final var seconds = Observable
                .interval(1, TimeUnit.SECONDS);

        final var compositeDisposable = new CompositeDisposable();

        seconds.subscribe(new Observer<>() {
            @Override
            public void onSubscribe(io.reactivex.rxjava3.disposables.@NonNull Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(@NonNull Long aLong) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        compositeDisposable.dispose();
    }

    private static void disposableExample3() {
        final var seconds = Observable
                .interval(1, TimeUnit.SECONDS);

        final var resourceObserver = new ResourceObserver<Long>() {
            @Override
            public void onNext(@NonNull Long o) {
                System.out.println("Item: " + o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        seconds.subscribe(resourceObserver);
        resourceObserver.dispose();
    }
}
