package org.firstinspires.ftc.teamcode.state_machines;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.state_machines.groups.BlueAuto;
import org.firstinspires.ftc.teamcode.state_machines.groups.CommandGroup;
import org.firstinspires.ftc.teamcode.state_machines.commands.RedAuto;
import org.firstinspires.ftc.teamcode.hardware.TankDrive;

/**
 * Created by nicholas on 6/23/17.
 */

public class AwesomeStateMachine extends OpMode {
    TankDrive robot = new TankDrive();
    CommandGroup blue_auto = new BlueAuto();
    CommandGroup red_auto = new RedAuto();
    boolean blue = true;

    public void init() {
        robot.init(hardwareMap);
    }

    public void loop() {
        if (blue) {
            blue_auto.loop();
        } else {
            red_auto.loop();
        }
    }
}
