package com.wangyao.dp.creational.singleton;

/**
 * 意图:
 *      保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 适用性:
 *      当类只能有一个实例而且客户可以从一个众所周知的访问点访问它时。
 *      当这个唯一实例应该是通过子类化可扩展的，并且客户应该无需更改代码就能使用一个扩展的实例时。
 * @author wangyao
 * 
 */
public class Singleton {

    // static初始化，其他方法不包含new语句。
    private static Singleton s = new Singleton();

    // 注，若在Singleton定义成员变量或类变量，使用时注意同步问题，为使用该资源的方法或代码块加synchronized修饰符。

    /**
     * 构造方法，必须为私有性质
     */
    private Singleton() {
    };

    /**
     * 同步方法A
     */
    public synchronized void methodA() {

    }

    /**
     * 同步方法B
     */
    public synchronized void methodB() {

    }

    /**
     * 继承自Object的方法，因为是单态，因此不支持克隆。
     */
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton class can't clone!");
    }

    /**
     * 方法1：static初始化，将初始化代码放到实例s定义处或静态代码块中。推荐使用此种方式。
     */
    public static Singleton getInstance() {
        return s;
    }

    // /**
    // * 方法2：惰性初始化，将初始化放在getInstance中，但此方法在多线程下可能创建多个实例。
    // */
    // public static Singleton getInstance() {
    // if (null == s) {
    // s = new Singleton();
    // }
    //
    // return s;
    // }

    // /**
    // * 方法3：同步方法 + 惰性初始化，此种方法可用。但性能不如方法1。
    // */
    // public synchronized static Singleton getInstance() {
    // if (null == s) {
    // s = new Singleton();
    // }
    //
    // return s;
    // }

    // /**
    // * 方法4：双重检查锁，对方法2、3的修正，但内存模型允许所谓的“无序写入”，此种方法不可实用。
    // */
    // public static Singleton getInstance() {
    // if (null == s) {
    // synchronized (Singleton.class) {
    // if (null == s) {
    // s = new Singleton();
    // }
    // }
    // }
    //
    // return s;
    // }

    // /**
    // * 方法5：双重检查锁变种，但依然存在内存的“无序写入”问题，故也不可实用。
    // */
    // public static Singleton getInstance() {
    // if (null == s) {
    // synchronized (Singleton.class) {
    // Singleton inst = s;
    // if (null == inst) {
    // synchronized (Singleton.class) {
    // inst = new Singleton();
    // }
    // s = inst;
    // }
    // }
    // }
    //
    // return s;
    // }

}
