package com.nbusto.patterns.observer.observer;

import com.nbusto.patterns.observer.subject.Subject;

public interface Observer<T extends Subject<T>> {
    void update();

    void setSubject(T subject);
}
