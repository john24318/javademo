package com.wangyao.dp.structural.decorator;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // create a decorated Window with horizontal and vertical scrollbars
        Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(
                new SimpleWindow()));

        // print the Window's description
        System.out.println(decoratedWindow.getDescription());

    }

}
