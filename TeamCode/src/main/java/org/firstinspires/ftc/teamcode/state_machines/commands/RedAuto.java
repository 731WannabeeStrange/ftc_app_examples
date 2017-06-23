package org.firstinspires.ftc.teamcode.state_machines.commands;

import org.firstinspires.ftc.teamcode.state_machines.groups.CommandGroup;

/**
 * Created by nicholas on 6/23/17.
 */

public class RedAuto extends CommandGroup {
    public RedAuto() {
        addSequential(new TimeDrive(0, -1, 0, 5000));
        addSequential(new TimeDrive(0, 1, 0, 5000));
        addSequential(new Stop());
    }
}
