package game.actions.macro;

import game.actions.Command;
import game.actions.fuel.BurnFuelCommand;
import game.actions.fuel.CheckFuelCommand;
import game.actions.movement.MoveCommand;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class MacroCommandFactory {

    public MacroCommand createMoveBurnFuelMacroCommand(CheckFuelCommand checkFuelCommand, MoveCommand moveCommand, BurnFuelCommand burnFuelCommand) {
        List<Command> commands = Arrays.asList(checkFuelCommand, moveCommand, burnFuelCommand);
        return new MacroCommand(commands);
    }

}
