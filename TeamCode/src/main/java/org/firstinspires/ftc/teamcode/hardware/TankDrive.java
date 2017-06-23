package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.RobotBase;

/**
 * Created by nicholas on 6/23/17.
 */

public class TankDrive extends RobotBase {
    public static DcMotor left;
    public static DcMotor right;

    public static void init(HardwareMap hardwareMap) {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        left.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public static void drive(double x, double y, double angular_velocity) {
        right.setPower(y - angular_velocity);
        left.setPower(y - angular_velocity);
    }

    public static void stop() {
        left.setPower(0);
        right.setPower(0);
    }
}
