package org.firstinspires.ftc.teamcode.state_machines.commands;

/**
 * Created by nicholas on 6/23/17.
 */

public class CommandType {
    public boolean parallel;
    public Command command;

    public CommandType(Command command, boolean parallel) {
        this.command = command;
        this.parallel = parallel;
    }

}
