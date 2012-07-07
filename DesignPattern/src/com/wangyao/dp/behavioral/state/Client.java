package com.wangyao.dp.behavioral.state;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        FireSwitch fireSwitch = new FireSwitch();
        fireSwitch.request();
        fireSwitch.request();
        fireSwitch.request();
        fireSwitch.request();
    }

}
