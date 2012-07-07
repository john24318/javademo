package com.wangyao.dp.creational.abstractfactory;

public class MacWidgetFactory implements IWidgetFactory {

    public IButton createButton() {
        return new MacButton();
    }

    public ITextField createTextField() {
        return new MacTextField();
    }

}
