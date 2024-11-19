package org.delta.observer;

public class TestObservers {

    public static void main(String[] a) {
        // Observer test
        MyTopic topic = new MyTopic();

        MyTopicSubscriber sub1 = new MyTopicSubscriber("Obj1");
        MyTopicSubscriber sub2 = new MyTopicSubscriber("Obj2");
        MyTopicSubscriber sub3 = new MyTopicSubscriber("Obj3");

        topic.register(sub1);
        topic.register(sub2);
        topic.register(sub3);

        // Check if any update is available
        sub1.update();

        // Now send message to subject
        topic.postMessage("New Message");
    }
}
