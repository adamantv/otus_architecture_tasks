package game.queue;

import game.actions.Command;
import game.actions.log.LogCommand;
import game.actions.movement.MoveCommand;
import game.actions.repeat.RepeatCommand;
import game.actions.repeat.RepeatableAdapter;
import game.actions.rotation.RotatableCommand;
import game.elements.GameElement;
import game.exception.UnsupportedCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommandQueueTest {
    @Test
    @DisplayName("Commands actually added to the queue")
    void addCommandsToQueueCorrect() {
        ExceptionHandler exceptionHandler = mock(ExceptionHandler.class);
        CommandQueue commandQueue = new CommandQueue(new LinkedList<>(), exceptionHandler);
        MoveCommand moveCommand = mock(MoveCommand.class);
        RotatableCommand rotatableCommand = mock(RotatableCommand.class);
        commandQueue.addCommandToQueue(moveCommand);
        commandQueue.addCommandToQueue(rotatableCommand);
        assertNotNull(commandQueue.getQueue());
        assertEquals(commandQueue.getQueue().size(), 2);
        assertTrue(commandQueue.getQueue().peek() instanceof MoveCommand);
    }

    @Test
    @DisplayName("ExceptionHandler is actually called when exception is thrown")
    void checkUseHandler() {
        ExceptionHandler exceptionHandler = mock(ExceptionHandler.class);
        CommandQueue commandQueue = new CommandQueue(new LinkedList<>(), exceptionHandler);
        MoveCommand moveCommand = mock(MoveCommand.class);
        commandQueue.addCommandToQueue(moveCommand);
        UnsupportedCommandException e = new UnsupportedCommandException("");
        doThrow(e).when(moveCommand).execute();
        commandQueue.executeQueue();
        verify(exceptionHandler).handle(moveCommand, e);
    }

    @Test
    @DisplayName("When execute RepeatCommand from the queue, the command to be repeated is actually called")
    void checkWorkingRepeatCommand() {
        ExceptionHandler exceptionHandler = mock(ExceptionHandler.class);
        MoveCommand moveCommand = mock(MoveCommand.class);
        CommandQueue commandQueue = new CommandQueue(new LinkedList<>(), exceptionHandler);
        GameElement<Command> gameElement = new GameElement<>();
        gameElement.setProperty("command", moveCommand);
        RepeatCommand repeatCommand = new RepeatCommand(new RepeatableAdapter(gameElement));
        commandQueue.addCommandToQueue(repeatCommand);
        commandQueue.executeQueue();
        verify(moveCommand).execute();
    }

    @Test
    @DisplayName("LogCommand is actually called")
    void checkWorkingLogCommand() {
        ExceptionHandler exceptionHandler = mock(ExceptionHandler.class);
        CommandQueue commandQueue = new CommandQueue(new LinkedList<>(), exceptionHandler);
        LogCommand logCommand = mock(LogCommand.class);
        commandQueue.addCommandToQueue(logCommand);
        commandQueue.executeQueue();
        verify(logCommand).execute();
    }
}
