package com.wangyao.dp.structural.proxy;

/**
 * 意图：
 *      为其他对象提供一种代理以控制对这个对象的访问。
 * 适用性：
 *      
 *      
 * @author wangyao
 *
 */
public class ProxyImage implements Image {
    private String filename;
    private Image image;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void displayImage() {
        if (image == null) {
            image = new RealImage(filename); // load only on demand
        }
        image.displayImage();
    }

}
