package com.wangyao.dp.creational.abstractfactory;

/**
 * 意图:
 *      提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 * 适用性:
 *      一个系统要独立于它的产品的创建、组合和表示时。
 *      一个系统要由多个产品系列中的一个来配置时。
 *      当你要强调一系列相关的产品对象的设计以便进行联合使用时。
 *      当你提供一个产品类库，而只想显示它们的接口而不是实现时。
 * @author wangyao
 *
 */
public interface IWidgetFactory {
    public IButton createButton();

    public ITextField createTextField();
}
