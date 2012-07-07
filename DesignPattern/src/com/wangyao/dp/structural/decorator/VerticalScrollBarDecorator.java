package com.wangyao.dp.structural.decorator;

/**
 * ConcreteDecoratorB
 * 
 * @author wangyao
 * 
 */
public class VerticalScrollBarDecorator extends WindowDecorator {
    public VerticalScrollBarDecorator(Window decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }

    public void draw() {
        drawVerticalScrollBar();
        decoratedWindow.draw();
    }

    private void drawVerticalScrollBar() {
        // draw the vertical scrollbar
    }

    public String getDescription() {
        return decoratedWindow.getDescription() + ", including vertical scrollbars";
    }

}
