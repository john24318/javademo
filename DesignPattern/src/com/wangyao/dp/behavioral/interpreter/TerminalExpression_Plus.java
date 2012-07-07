package com.wangyao.dp.behavioral.interpreter;

import java.util.Stack;

public class TerminalExpression_Plus implements Expression {

    public void interpret(Stack<Integer> s) {
        s.push(s.pop() + s.pop());
    }

}
