package com.wangyao.dp.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite
 * 意图：
 *      将对象组合成树形结构以表示“部分-整体”的层次结构。Composite使得用户对单个对象和组合对象的使用具有一致性。
 * 适用性：
 *      你想表示对象的部分-整体层次结构。
 *      你希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
 * 
 * @author wangyao
 * 
 */
public class CompositeGraphic implements Graphic {

    // Collection of child graphics.
    private List<Graphic> mChildGraphics = new ArrayList<Graphic>();

    // Prints the graphic.
    public void print() {
        for (Graphic graphic : mChildGraphics) {
            graphic.print();
        }
    }

    // Adds the graphic to the composition.
    public void add(Graphic graphic) {
        mChildGraphics.add(graphic);
    }

    // Removes the graphic from the composition.
    public void remove(Graphic graphic) {
        mChildGraphics.remove(graphic);
    }

    public Graphic getChild(int index) {
        return mChildGraphics.get(index);
    }

}
