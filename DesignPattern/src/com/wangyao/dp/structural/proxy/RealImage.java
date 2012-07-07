package com.wangyao.dp.structural.proxy;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading   " + filename);
        // Potentially expensive operation
        // ...
    }

    public void displayImage() {
        System.out.println("Displaying " + filename);
    }

}
