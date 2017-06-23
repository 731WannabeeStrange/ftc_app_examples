package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.hardware.TankDrive;
import org.firstinspires.ftc.teamcode.state_machines.groups.BlueAuto;

/**
 * Created by nicholas on 6/23/17.
 */

public class TankDriveTeleop extends OpMode {
    TankDrive robot = new TankDrive();

    public void init() {
        robot.init(hardwareMap);
    }

    public void loop() {
        robot.drive(0, gamepad1.left_stick_y, gamepad1.right_stick_x);
    }
}
