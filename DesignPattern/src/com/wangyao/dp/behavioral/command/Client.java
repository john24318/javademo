package com.wangyao.dp.behavioral.command;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Light lamp = new Light();
        Command switchUp = new TurnOnCommand(lamp);
        Command switchDown = new TurnOffCommand(lamp);

        Switch s = new Switch(switchUp, switchDown);

        s.flipUp();
        s.flipDown();

    }

}
