package task2;

import org.junit.jupiter.api.Test;
import task2.actions.movement.MoveCommand;
import task2.actions.rotation.RotatableCommand;
import task2.queue.CommandQueue;
import task2.queue.ExceptionHandler;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class CommandQueueTest {
    @Test
    void addCommandsToQueueCorrect() {
        ExceptionHandler exceptionHandler = mock(ExceptionHandler.class);
        CommandQueue commandQueue = new CommandQueue(new LinkedList<>(), exceptionHandler);
        MoveCommand moveCommand = mock(MoveCommand.class);
        RotatableCommand rotatableCommand = mock(RotatableCommand.class);
        commandQueue.addCommandToQueue(moveCommand);
        commandQueue.addCommandToQueue(rotatableCommand);
        assertEquals(commandQueue.getQueue().size(), 2);
        assertTrue(commandQueue.getQueue().peek() instanceof MoveCommand);
    }
}
