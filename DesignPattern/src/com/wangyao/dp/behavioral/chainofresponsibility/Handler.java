package com.wangyao.dp.behavioral.chainofresponsibility;

/**
 * 意图
 *      使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
 * 适用性
 *      有多个的对象可以处理一个请求，哪个对象处理该请求运行时刻自动确定。
 *      你想在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
 *      可处理一个请求的对象集合应被动态指定。
 *      
 * @author wangyao
 *
 */
public class Handler {
    /**
     * 下一个处理对象
     */
    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public Handler getSuccessor() {
        return successor;
    }

    public void handleRequest(char c) {
        if (successor != null)
            successor.handleRequest(c);
    }
}
