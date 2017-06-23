package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by nicholas on 6/23/17.
 */

public class XHolonomicDrive extends RobotBase {
    public static DcMotor front_left;
    public static DcMotor front_right;
    public static DcMotor back_left;
    public static DcMotor back_right;

    public static void init(HardwareMap hardwareMap) {
        front_left = hardwareMap.dcMotor.get("left");
        front_right = hardwareMap.dcMotor.get("right");
        back_left = hardwareMap.dcMotor.get("left");
        back_right = hardwareMap.dcMotor.get("right");
    }

    public static void drive(double x, double y, double angular_velocity) {
        double fl = y + x + angular_velocity;
        double fr = -y + x + angular_velocity;
        double bl = y - x + angular_velocity;
        double br = -y - x + angular_velocity;

        front_left.setPower(fl);
        front_right.setPower(fr);
        back_left.setPower(bl);
        back_right.setPower(br);
    }

    public static void stop() {
        front_left.setPower(0);
        front_right.setPower(0);
        back_right.setPower(0);
        back_left.setPower(0);
    }
}
