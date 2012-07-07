package com.wangyao.dp.behavioral.command;

/**
 * the Command for turning off the light
 * 
 * @author wangyao
 * 
 */
public class TurnOffCommand implements Command {
    private Light theLight;

    public TurnOffCommand(Light light) {
        this.theLight = light;
    }

    public void execute() {
        theLight.turnOff();
    }
}
