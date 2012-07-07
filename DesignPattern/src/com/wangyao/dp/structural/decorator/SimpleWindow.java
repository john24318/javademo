package com.wangyao.dp.structural.decorator;

/**
 * ConcreteComponent
 * 
 * @author wangyao
 * 
 */
public class SimpleWindow implements Window {

    public void draw() {
        // draw window
    }

    public String getDescription() {
        return "simple window";
    }

}
