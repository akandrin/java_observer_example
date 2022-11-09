package com;

import java.util.ArrayList;
import java.util.List;

public class Observable implements IObservable {
    private List<IObserver> observers = new ArrayList<>();

    @Override
    public void Attach(IObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void Detach(IObserver observer) {
        if (observer != null)
        {
            observers.remove(observer);
        }
    }

    @Override
    public void DetachObserverByName(String name) {
        observers.removeIf(element -> element.GetName().equals(name));
    }

    @Override
    public void Notify(String message) {
        for (IObserver observer : observers)
        {
            observer.Update(message);
        }
    }
}
