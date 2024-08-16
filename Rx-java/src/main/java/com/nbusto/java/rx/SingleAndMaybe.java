package com.nbusto.java.rx;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

import java.util.Optional;

public class SingleAndMaybe {

    public static void main(String[] args) {
        single();
        System.out.println("--------------------------");
        maybe();
    }

    private static void single() {
        Single.create(it ->
                        Optional.ofNullable(fetchUser())
                                .ifPresentOrElse(it::onSuccess, () -> it.onError(new Exception("User not found")))
                )
                .doOnSuccess(System.out::println)
                .doOnError(it -> System.out.println(it.getMessage()))
                .subscribe();
    }

    private static void maybe() {
        Maybe.create(it ->
                        Optional.ofNullable(fetchUser())
                                .ifPresentOrElse(it::onSuccess, it::onComplete))
                .doOnSuccess(System.out::println)
                .doOnComplete(() -> System.out.println("No new content"))
                .subscribe();
    }

    private static String fetchUser() {
        return "John";
    }
}
