package com.wangyao.dp.structural.bridge;

/**
 * 意图：
 *      将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * 适用性：
 *      
 * @author wangyao
 * 
 */
public abstract class Message {
    protected MessageLogger logger;

    public abstract void log(String msg);
}
