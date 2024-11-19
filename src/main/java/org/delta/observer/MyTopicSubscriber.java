package org.delta.observer;

import java.util.List;

public class MyTopicSubscriber implements Observer {
    private Subject subject;

    public MyTopicSubscriber(String name) {
    }

    @Override
    public void update() {
        String msg = (String) subject.getUpdate(this);
        if (msg == null) {
            System.out.println(":: No new message");
        } else {
            System.out.println(":: Consuming message: " + msg);
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
