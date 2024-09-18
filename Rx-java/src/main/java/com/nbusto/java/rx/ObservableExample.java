package com.nbusto.java.rx;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.List;

public class ObservableExample {

  public static void main(String[] args) {
    //simpleObservable();
    //observerDefinition();
    //observerFromList();
    //range();
    actionCompleted();
  }

  private static void simpleObservable() {
    System.out.println(io.reactivex.rxjava3.core.Observable.create(it -> {
        it.onNext("Test 1");
        it.onNext("Test 2");
        it.onNext("Test 3");
        it.onComplete();
      }).subscribe(
        System.out::println,
        it -> System.out.println(it.getMessage()),
        () -> System.out.println("End"))
      .isDisposed());
  }

  private static void observerDefinition() {
    io.reactivex.rxjava3.core.Observable.just("Item 1", "Item 2")
      .subscribe(new Observer<>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {}

        @Override
        public void onNext(@NonNull String s) {
          System.out.println(s);
        }

        @Override
        public void onError(@NonNull Throwable e) {}

        @Override
        public void onComplete() {
          System.out.println("On complete called!");
        }
      });
  }

  private static void observerFromList() {
    io.reactivex.rxjava3.core.Observable.fromIterable(List.of(1, 2))
      .subscribe(new Observer<>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {}

        @Override
        public void onNext(@NonNull Integer integer) {
          System.out.println(integer);
        }

        @Override
        public void onError(@NonNull Throwable e) {}

        @Override
        public void onComplete() {
          System.out.println("On complete called!");
        }
      });
  }

  private static void range() {
    io.reactivex.rxjava3.core.Observable.range(2, 5)
      .subscribe(System.out::println)
      .dispose();
  }

    /*private static void interval() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(System.out::println)
                .dispose();
    }*/

    /*private static void timer() {
        Observable.timer(5, TimeUnit.SECONDS)
                .subscribe(System.out::println)
                .dispose();
    }*/

  private static void actionCompleted() {
    io.reactivex.rxjava3.core.Observable.fromAction(() -> System.out.println("Completed"))
      .subscribe()
      .dispose();
  }
}
