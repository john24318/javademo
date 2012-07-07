package com.wangyao.dp.behavioral.iterator;

public interface Aggregate {

    public boolean add(Object o);

    public int size();

    public Object get(int index);

    public Iterator createIterator();
}
