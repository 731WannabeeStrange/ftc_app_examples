package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import static android.R.attr.delay;
import static android.telephony.PhoneNumberUtils.WAIT;
import static java.lang.System.currentTimeMillis;

/**
 * Created by nicholas on 6/1III2/17.
 */

@Autonomous
public class Test extends OpMode {
    DcMotor left;
    DcMotor right;

    //magic numbers
    float POWER = 0.75f; /* [-1, 1] */
    final long RUN_TIME = 3000; /* (0, infinity) */
    final long BREAK_TIME = 1000; /* (0, infinity) */

    //state machine and timer
    int state;
    long init_time;

    public void init() {
        left = hardwareMap.dcMotor.get("left");
        left.setDirection(DcMotorSimple.Direction.FORWARD);

        right = hardwareMap.dcMotor.get("right");
        right.setDirection(DcMotorSimple.Direction.REVERSE);

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //telemetry
        //print encoder values to console
        telemetry.addData("leftEncoder: ", left.getCurrentPosition());
        telemetry.addData("rightEncoder: ", right.getCurrentPosition());
        telemetry.update();


        //initialize state and timer
        state = 0;
        init_time = System.currentTimeMillis();
    }



    public void loop() {

        telemetry.addData("leftEncoder: ", left.getCurrentPosition());
        telemetry.addData("rightEncoder: ", right.getCurrentPosition());
        telemetry.addData("STATE: ", state);
        telemetry.addData("InitTime: ", init_time);
        telemetry.addData("Time: ", System.currentTimeMillis());
        telemetry.update();

        switch (state) {
            case 0:

                //both motors ON
                left.setPower(POWER);
                right.setPower(POWER);

                //initialize counter

                if (System.currentTimeMillis() >= (init_time + RUN_TIME)) {
                    state = 1;
                }

                break;

            case 1:

                //both motors OFF
                left.setPower(0);
                right.setPower(0);

                if (System.currentTimeMillis() >= (init_time + BREAK_TIME)) {
                    state = 2;
                }

                break;

            case 2:

                //both motors REVERSE
                left.setPower((-1) * POWER);
                right.setPower((-1) * POWER);

                if (System.currentTimeMillis() >= (init_time + RUN_TIME)) {
                    state = 3;
                }

                break;

            case 3:

                //both motors OFF
                left.setPower(0);
                right.setPower(0);

                if (System.currentTimeMillis() >= (init_time + BREAK_TIME)) {
                    //reverse initial direction next time
                    POWER = (-1) * POWER;
                    state = 0;
                }

                break;
        }
    }
}