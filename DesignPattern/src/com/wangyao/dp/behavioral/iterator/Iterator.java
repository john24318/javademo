package com.wangyao.dp.behavioral.iterator;

/**
 * 意图：
 *      提供一种方法顺序访问一个聚合对象中各个元素, 而又不需暴露该对象的内部表示。
 * 适用性：
 *      访问一个聚合对象的内容而无需暴露它的内部表示。
 *      支持对聚合对象的多种遍历。
 *      为遍历不同的聚合结构提供一个统一的接口(即, 支持多态迭代)。
 * @author wangyao
 *
 */
public interface Iterator {
    public Object first();

    public Object next();

    public boolean isDone();

    public Object currentItem();
}
