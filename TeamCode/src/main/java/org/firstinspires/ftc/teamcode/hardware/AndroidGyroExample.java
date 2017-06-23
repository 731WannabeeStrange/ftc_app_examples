package org.firstinspires.ftc.teamcode.hardware;

import android.content.Context;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.hardware.AndroidGyro;

/**
 * Created by nicholas on 6/23/17.
 */

public class AndroidGyroExample extends OpMode {
    AndroidGyro gyro;

    public void init() {
        gyro = new AndroidGyro(hardwareMap.appContext);
    }

    public void loop() {
        telemetry.addData("gyro", gyro.getX());
    }
}
