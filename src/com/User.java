package com;

// Пользователь рассылки новостных уведомлений
public class User extends Observable implements IObserver {

    private String name;

    public User(String name)
    {
        this.name = name;
    }

    @Override
    public void Update(String message) {
        // пользователь уведомляет сервис об успешном получении сообщения
        Notify("User " + name + " has got a message \"" + message + "\"");
    }

    @Override
    public String GetName() {
        return name;
    }
}
