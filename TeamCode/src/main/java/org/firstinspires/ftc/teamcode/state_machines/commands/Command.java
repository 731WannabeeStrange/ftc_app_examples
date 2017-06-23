package org.firstinspires.ftc.teamcode.state_machines.commands;

/**
 * Created by nicholas on 6/23/17.
 */

public abstract class Command {
    public boolean started = false;

    public abstract void init();

    public abstract void loop();

    public abstract boolean isFinished();

    public abstract void stop();
}
