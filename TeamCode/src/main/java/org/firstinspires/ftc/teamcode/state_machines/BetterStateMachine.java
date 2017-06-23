package org.firstinspires.ftc.teamcode.state_machines;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.ArrayList;

import static org.firstinspires.ftc.teamcode.state_machines.BetterStateMachine.RobotState.Drive;
import static org.firstinspires.ftc.teamcode.state_machines.BetterStateMachine.RobotState.Stop;
import static org.firstinspires.ftc.teamcode.state_machines.BetterStateMachine.RobotState.Wait;

/**
 * Created by nicholas on 6/13/17.
 */

public class BetterStateMachine extends OpMode {
    int iteration = 0;

    enum RobotState {
        Drive,
        Wait,
        Stop
    }

    public boolean drive(double distance) {
        return false;
    }

    public boolean wait_time(long time) {
        return false;
    }

    public void stopMotors() {}

    ArrayList loop = new ArrayList<BetterState>();

    public void init() {
        loop.add(new BetterState(Drive, 10));
        loop.add(new BetterState(Wait, 1000));
        loop.add(new BetterState(Drive, -10));
        loop.add(new BetterState(Stop));
    }

    public void loop() {
        BetterState i = (BetterState) loop.get(iteration);
        switch(i.type) {
            case Drive:
                if (drive(i.distance)) {
                    iteration++;
                }
                break;
            case Wait:
                if (wait_time(i.time)) {
                    iteration++;
                }
                break;
            case Stop:
                stopMotors();
                break;
        }
    }

}
