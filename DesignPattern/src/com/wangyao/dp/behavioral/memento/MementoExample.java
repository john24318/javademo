package com.wangyao.dp.behavioral.memento;

public class MementoExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();

        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        caretaker.addMemento(originator.createMemento());
        originator.set("State3");
        caretaker.addMemento(originator.createMemento());
        originator.set("State4");

        originator.setMemento(caretaker.getMemento(1));
    }

}
