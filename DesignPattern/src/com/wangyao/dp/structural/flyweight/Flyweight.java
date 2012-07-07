package com.wangyao.dp.structural.flyweight;

/**
 * 意图：
 *      避免大量拥有相同内容的对象的开销，使大家共享对象。
 * 适用性：
 *      一个应用程序使用了大量的相同对象。
 *      
 * @author wangyao
 *
 */
public interface Flyweight {

    public void operation(String extrinsicState);

}
