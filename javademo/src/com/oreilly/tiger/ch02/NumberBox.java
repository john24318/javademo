package com.oreilly.tiger.ch02;

import java.util.Iterator;

/**
 * 泛型示例：限制泛型的类型
 * 
 * @author wangyao
 * 
 * @param <N>
 */
public class NumberBox<N extends Number> extends Box<N> {

	public NumberBox() {
		super();
	}

	// Sum everything in the box
	public double sum() {
		double total = 0;
		for (Iterator<N> i = contents.iterator(); i.hasNext();) {
			total = total + i.next().doubleValue();
		}
		return total;
	}

	public static <A extends Number> double sum(Box<A> box1, Box<A> box2) {
		double total = 0;
		for (Iterator<A> i = box1.contents.iterator(); i.hasNext();) {
			total = total + i.next().doubleValue();
		}
		for (Iterator<A> i = box2.contents.iterator(); i.hasNext();) {
			total = total + i.next().doubleValue();
		}
		return total;
	}
}