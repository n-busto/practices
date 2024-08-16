package com.nbusto.patterns.observer.subject;

import com.nbusto.patterns.observer.observer.Observer;

import java.util.List;

public interface Subject<T extends Subject<T>> {
    void registerObserver(Observer<T> observer);

    void removeObserver(Observer<T> observer);

    List<Observer<T>> getObservers();

    default void notifyObservers() {
        getObservers().forEach(Observer::update);
    }
}
