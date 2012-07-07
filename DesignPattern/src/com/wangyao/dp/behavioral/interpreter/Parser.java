package com.wangyao.dp.behavioral.interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class Parser {
    // only one NonTerminal Expression here
    private ArrayList<Expression> parseTree = new ArrayList<Expression>();

    public Parser(String s) {
        for (String token : s.split(" ")) {
            if (token.equals("+"))
                parseTree.add(new TerminalExpression_Plus());
            else if (token.equals("-"))
                parseTree.add(new TerminalExpression_Minus());
            // ...
            else
                parseTree.add(new TerminalExpression_Number(Integer.valueOf(token)));
        }
    }

    public int evaluate() {
        Stack<Integer> context = new Stack<Integer>();
        for (Expression e : parseTree)
            e.interpret(context);
        return context.pop();
    }

}
