package org.delta.observer;

public interface Observer {
    void update();
    void setSubject(Subject subject);
}
