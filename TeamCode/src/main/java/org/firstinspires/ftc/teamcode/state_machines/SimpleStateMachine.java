package org.firstinspires.ftc.teamcode.state_machines;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import static android.R.attr.left;

/**
 * Created by nicholas on 6/13/17.
 */

public class SimpleStateMachine extends OpMode {
    int state;
    DcMotor motor;

    public boolean drive(int x) {
        telemetry.addData("Driving", x);
        if (motor.getCurrentPosition() >= x) {
            return true;
        } else {
            motor.setPower(1);
            return false;
        }
    }

    public void init() {
        motor = hardwareMap.dcMotor.get("motor");
        state = 0;
    }

    public void loop() {
        switch(state) {
            case 0:
                telemetry.addData("BetterState", 0);
                if (drive(10)) {
                    state = 1;
                }
                break;
            case 1:
                telemetry.addData("BetterState", 1);
                if (drive(-10)) {
                    state = 2;
                }
                break;
            case 2:
                telemetry.addData("Stop", 2);
                break;
        }
        telemetry.update();
    }
}
