package com.wangyao.dp.behavioral.observer;

public class ConcreteObserver implements Observer {
    private String name;
    private ConcreteSubject concreteSubject;

    public ConcreteObserver(String name, ConcreteSubject concreteSubject) {
        super();
        this.name = name;
        this.concreteSubject = concreteSubject;
    }

    public void update() {
        System.out.println(name + ":" + concreteSubject.getState());
    }

}
