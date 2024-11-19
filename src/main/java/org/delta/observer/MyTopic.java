package org.delta.observer;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {
    private final Object MUTEX = new Object();
    private String message;
    private boolean changed;

    private List<Observer> observers = new ArrayList<>();

    public MyTopic() {
    }

    public void register(Observer obj) {
        if (obj == null) {
            throw new NullPointerException("Null Observer");
        }

        synchronized (MUTEX) {
            if (!observers.contains(obj)) {
                observers.add(obj);
                obj.setSubject(this);
            }
        }

        observers.add(obj);
    }

    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    public void notifyObservers() {
        List<Observer> observersLocal = null;

        synchronized (MUTEX) {
            if (!changed) {
                return;
            }

            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }

        for (Observer observer : observers) {
            observer.update();
        }
    }

    public Object getUpdate(Observer obj) {
        return message;
    }

    public void postMessage(String msg) {
        System.out.println("Message posted to topic: " + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}
