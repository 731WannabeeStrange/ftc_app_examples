package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.hardware.TankDrive;
import org.firstinspires.ftc.teamcode.hardware.XHolonomicDrive;

/**
 * Created by nicholas on 6/23/17.
 */

public class XHolonomicDriveTeleop extends OpMode {
    XHolonomicDrive robot = new XHolonomicDrive();

    public void init() {
        robot.init(hardwareMap);
    }

    public void loop() {
        robot.drive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
    }
}
