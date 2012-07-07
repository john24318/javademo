package com.wangyao.dp.structural.decorator;

/**
 * Decorator
 * 意图：
 *      动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活。
 * 适用性：
 *      在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 *      处理那些可以撤消的职责。
 *      当不能采用生成子类的方法进行扩充时。
 *      
 * @author wangyao
 * 
 */
public abstract class WindowDecorator implements Window {
    protected Window decoratedWindow; // the Window being decorated
}
