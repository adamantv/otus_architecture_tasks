package game.actions.log;

import game.elements.UObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoggableAdapter implements Loggable {
    private final UObject<String> uObject;

    @Override
    public String getLog() {
        return uObject.getProperty(String.class, "log");
    }

    @Override
    public void setLog(String message) {
        uObject.setProperty("log", message);
    }
}
