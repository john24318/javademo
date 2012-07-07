package com.wangyao.dp.creational.builder;

public class ConcreteBuilder implements Builder {

    private Product product = null;

    public void buildPartA() {
        product = new Product();
        System.out.println("Create Product.");
    }

    public void buildPartB() {
        product.setName("Book");
        System.out.println("Set Product Name.");
    }

    public void buildPartC() {
        product.setPrice(88.88f);
        System.out.println("Set Product Price.");
    }

    public Product getResult() {
        return product;
    }

}
