package org.firstinspires.ftc.teamcode.state_machines.groups;

import org.firstinspires.ftc.teamcode.state_machines.commands.Stop;
import org.firstinspires.ftc.teamcode.state_machines.commands.TimeDrive;
import org.firstinspires.ftc.teamcode.state_machines.groups.CommandGroup;

/**
 * Created by nicholas on 6/23/17.
 */

public class BlueAuto extends CommandGroup {
    public BlueAuto() {
        addSequential(new TimeDrive(0, 1, 0, 5000));
        addSequential(new TimeDrive(0, -1, 0, 5000));
        addSequential(new Stop());
    }
}
