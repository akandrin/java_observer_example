package com;

// Интерфейс обозреваемой сущности
public interface IObservable {
    // Добавить наблюдателя.
    void Attach(IObserver observer);
    // Удалить наблюдателя.
    void Detach(IObserver observer);
    // Удалить наблюдателя по имени.
    void DetachObserverByName(String name);
    // Оповестить наблюдателей.
    void Notify(String message);
}
