package com.wangyao.dp.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Sheep extends Animal {
    List<Sheep> children = new ArrayList<Sheep>();

    /**
     * clone方法，若含有非String、Integer之类原始数据类型需要深度拷贝
     */
    @SuppressWarnings("unchecked")
    public Object clone() {
        Sheep sheep = null;
        sheep = (Sheep) super.clone();
        sheep.children = (List<Sheep>) ((ArrayList<Sheep>) children).clone();
        return sheep;
    }

    public static void main(String args[]) {
        Sheep s1 = new Sheep();
        Sheep s2 = (Sheep) s1.clone();

        System.out.println(s1);
        System.out.println(s2);
    }

}
