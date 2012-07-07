package com.wangyao.dp.behavioral.observer;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver("Observer 1", subject));
        subject.attach(new ConcreteObserver("Observer 2", subject));

        subject.setState("ABC");
    }

}
