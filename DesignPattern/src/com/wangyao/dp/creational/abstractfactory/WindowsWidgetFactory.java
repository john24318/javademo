package com.wangyao.dp.creational.abstractfactory;

public class WindowsWidgetFactory implements IWidgetFactory {

    public IButton createButton() {
        return new WindowsButton();
    }

    public ITextField createTextField() {
        return new WindowsTextField();
    }

}
