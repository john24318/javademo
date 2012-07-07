package com.wangyao.dp.behavioral.interpreter;

import java.util.Stack;

public class TerminalExpression_Number implements Expression {

    private int number;

    public TerminalExpression_Number(int number) {
        this.number = number;
    }

    public void interpret(Stack<Integer> s) {
        s.push(number);
    }

}
