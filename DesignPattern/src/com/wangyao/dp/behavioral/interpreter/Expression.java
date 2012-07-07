package com.wangyao.dp.behavioral.interpreter;

import java.util.Stack;

/**
 * 意图：
 *      给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
 * 适用性：
 *      当有一个语言需要解释执行, 并且你可将该语言中的句子表示为一个抽象语法树时，可使用解释器模式。
 *      文法简单。
 *      效率不是一个关键问题。
 * @author wangyao
 *
 */
public interface Expression {
    public void interpret(Stack<Integer> s);
}
