package org.firstinspires.ftc.teamcode.hardware;

import org.firstinspires.ftc.teamcode.hardware.BaseClass;

/**
 * Created by nicholas on 6/19/17.
 */

public class ExtendedBase extends BaseClass {
    @Override
    public void loop() {
        motor.setPower(.5);
    }
}
