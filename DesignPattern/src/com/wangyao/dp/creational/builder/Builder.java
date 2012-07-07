package com.wangyao.dp.creational.builder;

/**
 * 意图
 *      将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 适用性
 *      当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时。
 *      当构造过程必须允许被构造的对象有不同的表示时。
 * @author wangyao
 *
 */
public interface Builder {
    /**
     * 生产步骤A
     */
    public void buildPartA();

    /**
     * 生产步骤B
     */
    public void buildPartB();

    /**
     * 生产步骤C
     */
    public void buildPartC();

    /**
     * 返回生产好的产品
     * 
     * @return
     */
    public Product getResult();
}
