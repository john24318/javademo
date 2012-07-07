package com.wangyao.dp.behavioral.iterator;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("A");
        aggregate.add("B");
        aggregate.add("C");
        aggregate.add("D");

        for (Iterator it = aggregate.createIterator(); !it.isDone();) {
            Object o = it.next();
            System.out.println(":" +o);
        }
    }

}
