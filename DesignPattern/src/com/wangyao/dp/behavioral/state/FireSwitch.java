package com.wangyao.dp.behavioral.state;

public class FireSwitch {
    private State current;

    public FireSwitch() {
        current = new OffState();
    }

    public void setState(State s) {
        current = s;
    }

    public void request() {
        current.handle(this);
    }
}
