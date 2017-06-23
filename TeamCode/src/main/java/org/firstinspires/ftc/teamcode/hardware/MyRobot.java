package org.firstinspires.ftc.teamcode.hardware;

import android.util.Log;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by nicholas on 6/23/17.
 */

public class MyRobot extends TankDrive {
    public static DcMotor lift;

    public static void moveArm() {
        Log.d("Moves", "arm");
    }

    public static void init(HardwareMap hardwareMap) {
        TankDrive.init(hardwareMap);
        lift = hardwareMap.dcMotor.get("lift");
    }

    public static void liftUp() {
        lift.setPower(1);
    }

    public static void liftDown() {
        lift.setPower(-1);
    }
}
