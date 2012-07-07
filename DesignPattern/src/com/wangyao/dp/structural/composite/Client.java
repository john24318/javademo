package com.wangyao.dp.structural.composite;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Graphic ellipse = new Ellipse();
        Graphic rectangle = new Rectangle();
        CompositeGraphic graphic = new CompositeGraphic();

        graphic.add(ellipse);
        graphic.add(rectangle);
        graphic.print();
    }

}
