package com.wangyao.dp.behavioral.observer;

public class ConcreteSubject extends Subject {
    // Fields
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

}
