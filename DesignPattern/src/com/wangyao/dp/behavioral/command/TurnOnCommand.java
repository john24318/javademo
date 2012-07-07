package com.wangyao.dp.behavioral.command;

import sun.tools.jar.CommandLine;

/**
 * the Command for turning on the light
 * 
 * @author wangyao
 * 
 */
public class TurnOnCommand extends CommandLine implements Command {
    private Light theLight;

    public TurnOnCommand(Light light) {
        this.theLight = light;
    }

    public void execute() {
        theLight.turnOn();
    }
}
