package com.wangyao.dp.creational.abstractfactory;

public class CustomDialog {
    private IButton button;
    private ITextField textField;

    public CustomDialog(IWidgetFactory widgetFactory) {
        setWidgetFactory(widgetFactory);
    }

    // 由於客戶端只依賴於抽象的工廠，工廠如何實作並無關客戶端的事
    // 要抽換工廠並不需要改動客戶端的程式
    public void setWidgetFactory(IWidgetFactory widgetFactory) {
        setButton(widgetFactory.createButton());
        setTextField(widgetFactory.createTextField());
        // ....
    }

    public void layoutAllComponents() {
        // layout all components
    }

    // 這邊也是依賴抽象，實際改變了元件實例
    // 客戶端代碼也不用更改
    public void setButton(IButton button) {
        this.button = button;
    }

    public void setTextField(ITextField textField) {
        this.textField = textField;
    }

    public void showDialog() {
        this.paintDialog();
        button.paintButton();
        textField.paintTextField();
    }

    public void paintDialog() {
        System.out.println("custom dialog paints....");
    }

    public static void main(String[] args) {
        CustomDialog cd = new CustomDialog(new WindowsWidgetFactory());
        cd.showDialog();
        cd.setWidgetFactory(new MacWidgetFactory());
        cd.showDialog();
    }
}
