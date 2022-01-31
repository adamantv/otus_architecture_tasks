package game.actions.macro;

import game.actions.Command;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class MacroCommandFactory {

    public MacroCommand createMacroCommand(Command... commands) {
        return new MacroCommand(List.of(commands));
    }
}
