package com.nbusto.java.rx;

public class Completable {
    public static void main(String[] args) {
        io.reactivex.rxjava3.core.Completable
                .fromAction(() -> System.out.println("Deleted"))
                .subscribe(System.out::println)
                .dispose();
    }
}
