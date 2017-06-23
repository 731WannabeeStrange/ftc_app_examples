package org.firstinspires.ftc.teamcode.state_machines.commands;

import org.firstinspires.ftc.teamcode.hardware.MyRobot;

/**
 * Created by nicholas on 6/23/17.
 */

public class Stop extends Command {
    public void init() {
        MyRobot.stop();
    }

    public void loop() {}

    public boolean isFinished() { return true; }

    public void stop() {}
}
