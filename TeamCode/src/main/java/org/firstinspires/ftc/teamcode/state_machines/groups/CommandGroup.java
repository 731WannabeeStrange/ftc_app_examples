package org.firstinspires.ftc.teamcode.state_machines.groups;

import org.firstinspires.ftc.teamcode.state_machines.commands.Command;
import org.firstinspires.ftc.teamcode.state_machines.commands.CommandType;

import java.util.ArrayList;
import java.util.Iterator;

import static android.media.CamcorderProfile.get;

public class CommandGroup {
    private ArrayList<CommandType> commands;
    private ArrayList<Command> parallel_commands;

    public void addSequential(Command command) {
       commands.add(new CommandType(command, false));
    }

    public void addParallel(Command command) {
        commands.add(new CommandType(command, true));
    }

    private int iteration = 0;

    public void loop() {
        CommandType i = commands.get(iteration);
        Command c = i.command;

        if (i.parallel) {
            parallel_commands.add(c);
            iteration++;
        } else {
            if (!c.started) {
                c.init();
                c.started = true;
            }

            if (!c.isFinished()) {
                c.loop();
            } else {
                c.stop();
                iteration++;
            }
        }

        Iterator<Command> iterator = parallel_commands.iterator();
        while (iterator.hasNext()) {
            Command p = iterator.next();
            if (!p.started) {
                p.init();
                p.started = true;
            }

            if (p.isFinished()) {
                iterator.remove();
                break;
            } else {
                p.loop();
            }
        }
    }
}
