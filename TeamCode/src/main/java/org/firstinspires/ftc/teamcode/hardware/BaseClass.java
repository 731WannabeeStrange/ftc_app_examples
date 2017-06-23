package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by nicholas on 6/23/17.
 */

public class BaseClass extends OpMode {
    DcMotor motor;

    public void init() {
        motor = hardwareMap.dcMotor.get("motor");
    }

    public void loop() {}
}
