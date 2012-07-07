package com.wangyao.dp.structural.adapter;

/**
 * 意图：
 *      将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 * 适用性：
 *      你想使用一个已经存在的类，而它的接口不符合你的需求。
 *      
 * @author wangyao
 *
 */
public class Adapter implements Target {
    Adaptee adaptee;

    public Adapter() {
        super();
        this.adaptee = new Adaptee();
    }

    public void request() {
        adaptee.specificRequest();
    }

}
