package org.firstinspires.ftc.teamcode.state_machines;

import static org.firstinspires.ftc.teamcode.state_machines.BetterStateMachine.RobotState;

/**
 * Created by nicholas on 6/13/17.
 */

public class BetterState {
    public double distance;
    public long time;
    public RobotState type;

    BetterState(RobotState type, double input) {
        this.type = type;
        if (type == RobotState.Drive) {
            this.distance = input;
        } else if (type == RobotState.Wait) {
            this.time = (long) input;
        }
    }

    BetterState(RobotState type) {
        this.type = type;
    }
}
