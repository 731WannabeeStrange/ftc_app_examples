package org.firstinspires.ftc.teamcode.state_machines.commands;

import org.firstinspires.ftc.teamcode.hardware.MyRobot;

/**
 * Created by nicholas on 6/23/17.
 */

public class TimeDrive extends Command {
    double x;
    double y;
    double angular_velocity;
    long duration;
    long start;

    public TimeDrive(double x, double y, double angular_velocity, long duration) {
        this.x = x;
        this.y = y;
        this.angular_velocity = angular_velocity;
        this.duration = duration;
    }

    public void init() {
        this.start = System.currentTimeMillis();
    }

    public void loop() {
        MyRobot.drive(x, y, angular_velocity);
    }

    public boolean isFinished() {
        return ((System.currentTimeMillis() - start) >= duration);
    }

    public void stop() {
        MyRobot.stop();
    }
}
