package game.actions.macro;

import game.actions.Command;
import game.exception.CommandException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MacroCommand implements Command {
    private List<Command> commands;

    @Override
    public void execute() {
        try {
            commands.forEach(Command::execute);
        } catch (Exception e) {
            throw new CommandException("Command thrown exception: " + e.getMessage());
        }
    }
}