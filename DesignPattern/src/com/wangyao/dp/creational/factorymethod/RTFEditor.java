package com.wangyao.dp.creational.factorymethod;

public class RTFEditor extends AbstractEditor {

    public IDocument createDocument() {
        return new RTFDocument();
    }

    public static void main(String[] args) {
        AbstractEditor editor = new RTFEditor();
        editor.newDocument();
        editor.saveDocument();
        editor.closeDocument();
    }
}
