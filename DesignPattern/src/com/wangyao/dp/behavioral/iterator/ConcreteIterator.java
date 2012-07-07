package com.wangyao.dp.behavioral.iterator;

public class ConcreteIterator implements Iterator {
    private Aggregate aggregate;
    private int current = 0;

    public ConcreteIterator(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    public Object currentItem() {
        return aggregate.get(current);
    }

    public Object first() {
        return aggregate.get(0);
    }

    public boolean isDone() {
        return current >= aggregate.size();
    }

    public Object next() {
        Object ret = null;
        if (current <= aggregate.size() - 1) {
            ret = aggregate.get(current++);
        }
        return ret;
    }

}
