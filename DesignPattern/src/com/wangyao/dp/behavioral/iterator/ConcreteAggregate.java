package com.wangyao.dp.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate implements Aggregate {

    private List<Object> list = new ArrayList<Object>();

    public boolean add(Object o) {
        return list.add(o);
    }

    public int size() {
        return list.size();
    }

    public Object get(int index) {
        return list.get(index);
    }

    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}
